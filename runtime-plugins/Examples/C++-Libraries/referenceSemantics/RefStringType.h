#ifndef REFSTRINGTYPE
#define REFSTRINGTYPE
#include <string>
#include "BaseRefCounter.h"

// class myString extends std::string by a reference counter
namespace cbsLib{
	class myString: public std::string, public intrusive_ref_counter<myString> {
	public:
		template<typename T>
		myString(T t): std::string(t){}
	};
}
#endif
