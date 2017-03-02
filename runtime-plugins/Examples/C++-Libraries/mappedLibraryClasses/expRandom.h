#ifndef UINTGEN
#define UINTGEN
#include <random>
#include "../../C++-Libraries/referenceSemantics/BaseRefCounter.h"

// a class for generating random numbers
class expRandom: public cbsLib::intrusive_ref_counter<expRandom> {
private:
	std::default_random_engine generator;
	// exponential distribution (could be replaced by other distribution functions)
	std::exponential_distribution<double> distribution;
public:
	// standard distribution 0.5
	expRandom() :
			distribution(0.5) {
	}
	// distribution according to a rate
	expRandom(double rate) :
			distribution(rate) {
	}
	// generates random number
	int sample() {
		return distribution(generator);
	}
};
#endif
