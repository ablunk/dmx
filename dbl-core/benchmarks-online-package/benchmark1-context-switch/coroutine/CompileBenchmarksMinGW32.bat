g++ Switch.cpp ../SRC/simulation/simulation.cpp ../SRC/copy-stack/coroutine.cpp ../SRC/simset/simset.cpp -o ContextSwitch-CopiedStack32 -I ../SRC/simulation -I ../SRC/copy-stack -I ../SRC/simset -I ../SRC/random -O3
g++ Switch.cpp ../SRC/simulation/simulation.cpp ../SRC/share-stack/coroutine.cpp ../SRC/simset/simset.cpp -o ContextSwitch-SharedStack32 -I ../SRC/simulation -I ../SRC/share-stack -I ../SRC/simset -I ../SRC/random -O3

g++ --version
