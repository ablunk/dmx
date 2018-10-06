# Beispiel für eine CMakeLists.txt, die in ODEMx-Projekten benutzt werden kann.
#
# Hinweise:
#  - Pfade müssen an den entsprechenden Stellen angepasst werden (normalerweise nur ODEMX_INSTALL und bei Bedarf MINGW_DIR)
#  - bei Verwendung des ODEMx-Debuggers muss "-DCMAKE_BUILD_TYPE=Debug" zum cmake-Aufruf hinzugefügt werden

### Projektname kann angepasst werden ###
PROJECT(GeneralPerformanceTest CXX)
### STOP ###

cmake_minimum_required(VERSION 2.8)
option(CMAKE_COLOR_MAKEFILE "color makefiles" ON)

### Pfade anpassen ###
set(ODEMX_INSTALL C:/tms-2014-tampa/benchmarks-improved/odemx-core/installs/release-fibers-mingw)
### STOP ###

if(${CMAKE_GENERATOR} MATCHES "MSYS|MinGW")
    set(USING_MINGW ON)
    message(STATUS "Using MinGW Paths.")

    ### Pfade anpassen ###
    set(MINGW_DIR C:/MinGW)
    set(ODEMX_INSTALL C:/tms-2014-tampa/benchmarks-improved/odemx-core/installs/release-fibers-mingw)
    ### STOP ###

    	INCLUDE_DIRECTORIES(${MINGW_DIR}/include ${MINGW_DIR}/lib/gcc/mingw32/4.5.0/include ${MINGW_DIR}/lib/gcc/mingw32/4.5.0/include/c++)
    INCLUDE_DIRECTORIES(${MINGW_DIR}/lib/gcc/mingw32/4.5.0/include/c++/backward ${MINGW_DIR}/lib/gcc/mingw32/4.5.0/include/c++/mingw32)
    INCLUDE_DIRECTORIES(${MINGW_DIR}/lib/gcc/mingw32/4.5.0/include-fixed)
endif()

### Pfade NUR bei Verwendung eigener Versionen der entspr. Bibliotheken anpassen (normalerweise hier nichts ändern) ###
set(POCO_INSTALL ${ODEMX_INSTALL})
set(GSL_INSTALL ${ODEMX_INSTALL})
### STOP ###


### Ab hier nichts ändern (außer du weißt was du tust)! ###

set(RELEASE_FLAGS "-Wall -O3 -Wno-sign-compare")
set(DEBUG_FLAGS "-g3 -Wall -Wno-sign-compare")

if (CMAKE_BUILD_TYPE)
	string(TOUPPER ${CMAKE_BUILD_TYPE} BUILD_TYPE)
	if (${BUILD_TYPE} STREQUAL "DEBUG")
		message(STATUS "Using Debug Library odemxD.")
		set(DEBUG_MODE ON)
	endif()
endif()

INCLUDE_DIRECTORIES(${ODEMX_INSTALL}/include ${POCO_INSTALL}/include ${GSL_INSTALL}/include)

if(DEBUG_MODE)
    find_library(ODEMX odemxD PATH ${ODEMX_INSTALL}/lib)
	if (NOT ODEMX)
		message(STATUS "Debug Library odemxD not found. Using Release Library odemx")
		find_library(ODEMX odemx PATH ${ODEMX_INSTALL}/lib)
	endif()
else()
    find_library(ODEMX odemx PATH ${ODEMX_INSTALL}/lib)
	if (NOT ODEMX)
		message(STATUS "Release Library odemx not found. Using Debug Library odemxD")
		find_library(ODEMX odemxD PATH ${ODEMX_INSTALL}/lib)	
	endif()
endif()

find_library(POCODATA PocoData PATH ${POCO_INSTALL}/lib)
find_library(POCOFOUNDATION PocoFoundation PATH ${POCO_INSTALL}/lib)
find_library(POCOSQLITE  PocoSQLite PATH ${POCO_INSTALL}/lib)
find_library(POCOXML PocoXML PATH ${POCO_INSTALL}/lib)
find_library(GSL gsl PATH ${GSL_INSTALL}/lib)
find_library(GSLCBLAS gslcblas PATH ${GSL_INSTALL}/lib)

if(WIN32)
    find_library(IPHLPAPI iphlpapi PATH ${MINGW_DIR}/lib)
    find_library(PSAPI psapi PATH ${MINGW_DIR}/lib)
endif()

### hier Quellcode-Dateien hinzufügen (*.cpp steht für alle cpp Dateien in diesem Verzeichnis) hinzufügen ###
FILE(GLOB SRC *.cpp)
### STOP ###

include_directories(${CMAKE_CURRENT_SOURCE_DIR}/include)

# Name des Executable
add_executable(main ${SRC})

# Executable gegen angegebene Libraries linken
if(WIN32)
    target_link_libraries(main ${ODEMX} ${GSLCBLAS} ${GSL} ${POCOXML} ${POCOSQLITE} ${POCODATA} ${POCOFOUNDATION} ${IPHLPAPI} ${PSAPI})
else()
    target_link_libraries(main ${ODEMX} ${GSLCBLAS} ${GSL} ${POCOXML} ${POCOSQLITE} ${POCODATA} ${POCOFOUNDATION})
endif()

if(DEBUG_MODE)
    set_target_properties(main PROPERTIES COMPILE_FLAGS ${DEBUG_FLAGS})
else()
    set_target_properties(main PROPERTIES COMPILE_FLAGS ${RELEASE_FLAGS})
endif()

if(USING_MINGW)
    set_target_properties(main PROPERTIES LINK_FLAGS "-Wl,--enable-auto-import -Wl,--enable-stdcall-fixup -Wl,--stack=65536")
endif()
