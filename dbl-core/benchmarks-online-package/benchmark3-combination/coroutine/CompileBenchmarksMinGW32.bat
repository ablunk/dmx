g++ Fn2.cpp ../SRC/simulation/simulation.cpp ../SRC/copy-stack/coroutine.cpp ../SRC/simset/simset.cpp -o Fn2-CopiedStack32 -I ../SRC/simulation -I ../SRC/copy-stack -I ../SRC/simset -I ../SRC/random -O3 -fno-inline
g++ Fn2.cpp ../SRC/simulation/simulation.cpp ../SRC/share-stack/coroutine.cpp ../SRC/simset/simset.cpp -o Fn2-SharedStack32 -I ../SRC/simulation -I ../SRC/share-stack -I ../SRC/simset -I ../SRC/random -O3 -fno-inline

g++ --version
