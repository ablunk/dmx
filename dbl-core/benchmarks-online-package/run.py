import os, time, re

benchmarks = {
    #"cs":["coro_share","coro_copy"]
    #"cs":["dblc_g","dblc_f","dblc_s"]
    "cm":["dblc_g","dblc_f"]
    #"cs":["dblc_f","odemx","coro_copy","coro_share","jist","slx"],
    #"cm":["coro_copy","coro_share"]
    #"fn":["dblc_g"],
}

cs_num = 100000000
cs_runs = 20

fn_num = 2*400000000
fn_runs = 20

cm_num = 800000
cm_runs = 20

slx_cmd = "C:\Wolverine\SLX\se32.exe /silent /output output.txt"
jvm_cmd = "C:\Programme\Java\jre7\\bin\java"

work_dir = "C:\\tms-2014-tampa\\benchmarks-improved"

java_cores_dir = work_dir + "\java-cores\eclipse-workspace"
dblc_apps_dir = work_dir + "\dbl-core\prototype\\apps"

coro_dir = work_dir + "\COROUTINE-1.0\EXAMPLES"

coroCC = "../SRC/simulation/simulation.cpp ../SRC/simset/simset.cpp -I ../SRC/simulation -I ../SRC/simset -I ../SRC/random -I ../../c++-cores-common"

coroCCcopy = coroCC + " ../SRC/copy-stack/coroutine.cpp -I ../SRC/copy-stack"
coroCCshare = coroCC + " ../SRC/share-stack/coroutine.cpp -I ../SRC/share-stack"

cs_dir = "benchmark1-context-switch"
fn_dir = "benchmark2-function-calls"
cm_dir = "benchmark3-combination"

# --- C++ ---

def fn_cpp():
    exec_name = "fn1.exe"
    cpp_dir = work_dir + "\\" + fn_dir + "\\" + "c++"
    exec_full = cpp_dir + "\\" + exec_name
    opt_compile(exec_full, cpp_dir, "g++ -I ../../c++-cores-common fn1.cpp -fno-inline -O3 -o " + exec_name)
    run(exec_full + " " + str(fn_num), "output.log", fn_runs, "fn_cpp")

# --- DBL Core ---

def cs_dblc_f():
    exec_name = "fibers-cs.exe"
    exec_full = dblc_apps_dir + "\\" + exec_name
    opt_compile(exec_full, dblc_apps_dir, "g++ fibers-cs.cpp -O3 -o " + exec_name)
    run(exec_full + " " + str(cs_num), "output.log", cs_runs, "cs_dblc_f")

def cs_dblc_g():
    exec_name = "goto-cs.exe"
    exec_full = dblc_apps_dir + "\\" + exec_name
    opt_compile(exec_full, dblc_apps_dir, "g++ goto-cs.cpp -O3 -o " + exec_name)
    run(exec_full + " " + str(cs_num), "output.log", cs_runs, "cs_dblc_g")

def cs_dblc_s():
    exec_name = "switch-case-cs.exe"
    exec_full = dblc_apps_dir + "\\" + exec_name
    opt_compile(exec_full, dblc_apps_dir, "g++ switch-case-cs.cpp -O3 -o " + exec_name)
    run(exec_full + " " + str(cs_num), "output.log", cs_runs, "cs_dblc_s")

def fn_dblc_g():
    exec_name = "goto-fn1.exe"
    exec_full = dblc_apps_dir + "\\" + exec_name
    opt_compile(exec_full, dblc_apps_dir, "g++ goto-fn1.cpp -O3 -o " + exec_name)
    run(exec_full + " " + str(fn_num), "output.log", fn_runs, "fn_dblc_g")

def cm_dblc_f():
    exec_name = "fibers-fn2.exe"
    exec_full = dblc_apps_dir + "\\" + exec_name
    opt_compile(exec_full, dblc_apps_dir, "g++ fibers-fn2.cpp -O0 -o " + exec_name)
    run(exec_full + " " + str(cm_num), "output.log", cm_runs, "cm_dblc_f")

def cm_dblc_g():
    exec_name = "goto-fn2.exe"
    exec_full = dblc_apps_dir + "\\" + exec_name
    opt_compile(exec_full, dblc_apps_dir, "g++ goto-fn2.cpp -O0 -o " + exec_name)
    run(exec_full + " " + str(cm_num), "output.log", cm_runs, "cm_dblc_g")

# --- ODEMx ---

def cs_odemx():
    run(work_dir + "\odemx-core\ContextSwitch\\build-mingw-release\main.exe " + str(cs_num), "output.log", cs_runs, "cs_odemx")

# --- COROUTINE 1.0 ---

def cs_coro_copy():
    exec_name = "cs_coro_copy.exe"
    exec_full = coro_dir + "\\" + exec_name
    opt_compile(exec_full, coro_dir, "g++ " + coroCCcopy + " -O3 Switch.cpp -o " + exec_name)
    run(exec_full + " " + str(cs_num), "output.log", cs_runs, "cs_coro_copy")

def cs_coro_share():
    exec_name = "cs_coro_share.exe"
    exec_full = coro_dir + "\\" + exec_name
    opt_compile(exec_full, coro_dir, "g++ " + coroCCshare + " -O3 Switch.cpp -o " + exec_name)
    run(exec_full + " " + str(cs_num), "output.log", cs_runs, "cs_coro_share")

def cm_coro_copy():
    exec_name = "cm_coro_copy.exe"
    exec_full = coro_dir + "\\" + exec_name
    opt_compile(exec_full, coro_dir, "g++ " + coroCCcopy + " -O0 Fn2.cpp -o " + exec_name)
    run(exec_full + " " + str(cm_num), "output.log", cm_runs, "cm_coro_copy")

def cm_coro_share():
    exec_name = "cm_coro_share.exe"
    exec_full = coro_dir + "\\" + exec_name
    opt_compile(exec_full, coro_dir, "g++ " + coroCCshare + " -O0 Fn2.cpp -o " + exec_name)
    run(exec_full + " " + str(cm_num), "output.log", cm_runs, "cm_coro_share")

# --- JiST/Pro ---

def cs_jist():
    cp = "\"" + java_cores_dir + "\Benchmarks\\bin;" + java_cores_dir + "\JiST-Pro\\bin;" + java_cores_dir + "\JiST-Pro\\libs\\*;" + java_cores_dir + "\hub.sam.dmx\\bin\""

    run(jvm_cmd + " -cp " + cp + " benchmarks.jistpro.contextswitch.JavaMainSwitch " + str(cs_num),
            "output.log", cs_runs, "cs_jist")

# --- SLX ---

def cs_slx():
    run(slx_cmd + " " + cs_dir + "\slx\switch.slx " + str(cs_num),
            cs_dir + "\slx\output.log", cs_runs, "cs_slx")

def fn_slx():
    run(slx_cmd + " " + fn_dir + "\slx\\function-calls.slx " + str(fn_num),
            fn_dir + "\slx\output.log", fn_runs, "fn_slx")

def cm_slx():
    run(slx_cmd + " " + cm_dir + "\slx\\fn2.slx " + str(cm_num),
            cm_dir + "\slx\output.log", cm_runs, "cm_slx")

# --- run ---

def opt_compile(executable, compileDir, compileCmd):
    if not os.access(executable, os.F_OK):
        cdir = os.getcwd()
        os.chdir(compileDir)
        print("Compiling ...")
        os.system(compileCmd)
        print("Finished.")
        os.chdir(cdir)

def run(cmd, log_filename, runs, fprefix):
    if not os.access("results", os.F_OK):
        os.mkdir("results")

    #cxt_file = open("results/" + fprefix + "_concept_execution_times.txt", "w")
    #pxt_file = open("results/" + fprefix + "_program_execution_times.txt", "w")

    cxt_file = open("results/cxt_" + fprefix + ".txt", "w")
    pxt_file = open("results/pxt.txt", "w")

    for i in range(1, runs+1):
        print("===========================")
        print("benchmark: " + fprefix + " (" + str(i) + "/" + str(runs) + ")")
        print("---------------------------")
        start = time.clock()
        os.system(cmd)
        end = time.clock()
        pxtime = end - start
        print("---------------------------")
        print("program execution time: " + str(pxtime) + " s")
        pxt_file.write(str(pxtime) + "\n")

        log_file = open(log_filename, "r")
        cxtime = -1
        for line in log_file:
            if '\n' == line[-1]:
                line = line[:-1]
            if line[:10] == "time [s]: ":
                cxtime = line[10:]
                print("concept execution time: " + cxtime + " s")
                cxt_file.write(cxtime + "\n")

        if cxtime == -1:
            print("ERROR: time not found in output")

        log_file.close()

    print("===========================")
    pxt_file.close()
    cxt_file.close()

# --- MAIN ---

#if os.access("results", os.F_OK):
#    print("Deleting files in directory results/")
#    for root, dirs, files in os.walk("results"):
#        for name in files:
#            os.remove(os.path.join(root, name))

for b in benchmarks:
    for simcore in benchmarks[b]:
        if os.access("output.log", os.F_OK):
            print("Deleting output.log")
            os.remove("output.log")

        bf = "" + b + "_" + simcore
        print("Running " + bf)
        exec(bf + "()")

