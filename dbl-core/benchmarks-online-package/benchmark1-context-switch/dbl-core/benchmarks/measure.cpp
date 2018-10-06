#include <iostream>
#include <stdlib.h>
#include <fstream>



//#define MEASURE_EXEC_TIME
#ifdef MEASURE_EXEC_TIME

#define START_MEASURE  msum = 0; t0 = get_timestamp();

#define SUM_MEASURE  t1 = get_timestamp(); msum += (t1 - t0) / 1000000.0L;

#define PRINT_MEASURE(LABEL)  std::cout << "elapsed time for " << LABEL << ": " << msum << std::endl;

#define END_MEASURE  t1 = get_timestamp();

#define TIME_DIFF ((t1-t0) / 1000000.0)

#define WRITE_OUTPUT_LOG     std::ofstream out_log; \
    out_log.open("output.log", std::ios::out | std::ios::trunc); \
    if (out_log.is_open()) { \
        out_log << "time [s]: " << TIME_DIFF << "\n"; \
        out_log.close(); \
    }

#include <sys/time.h>
#include <ctime>

typedef unsigned long long timestamp_t;

static timestamp_t get_timestamp() {
    struct timeval now;
    gettimeofday(&now, NULL);
    return now.tv_usec + (timestamp_t)now.tv_sec * 1000000;
}

timestamp_t t0;
timestamp_t t1;
double msum = 0;
#endif

//#define PRINT_MEM_USAGE
#ifdef PRINT_MEM_USAGE
// compile with option -lpsapi
#include <windows.h>
#include <stdio.h>
#include <psapi.h>

void printMemUsage() {
    HANDLE hProcess;
    PROCESS_MEMORY_COUNTERS pmc;

    std::cout << "\nProcess ID: " << GetCurrentProcessId() << std::endl;

    hProcess = OpenProcess(PROCESS_QUERY_INFORMATION |
                           PROCESS_VM_READ,
                           FALSE, GetCurrentProcessId() );
    if (NULL != hProcess) {
        if ( GetProcessMemoryInfo( hProcess, &pmc, sizeof(pmc)) ) {
            printf( "PeakWorkingSetSize: %u KB\n", pmc.PeakWorkingSetSize / 1024 );
            printf( "WorkingSetSize: %d KB\n", pmc.WorkingSetSize / 1024 );
            std::cout << "PeakPagefileUsage: " << pmc.PeakPagefileUsage / 1024 << " KB" << std::endl;
            std::cout << "PagefileUsage: " << pmc.PagefileUsage / 1024 << " KB" << std::endl;
 
            // ... add other members from pmc, as needed ...
        }
        CloseHandle( hProcess );
    }
}
#endif
