#ifndef STRINGEXTENSION
#define STRINGEXTENSION

#include "RefStringType.h"
#include "vectorExtension.h"
#include <typeinfo>
#include <sstream>
#include "intrusive_ptr.h"
typedef cbsLib::intrusive_ptr<cbsLib::myString> stringPtr;

// here some free functions are defined to create a toString()-representation
// for objects like in Java

// boolean values has to be mapped on "true"/"false" instead of 1/0
inline std::string to_String(const bool expression) {
	if (expression)
		return "true";
	else
		return "false";
}

// integer values are put into a stream to get a toString()-representation
inline std::string to_String(const int expression) {
	std::stringstream ss;
	ss << expression;
	return ss.str();
}
// double values are put into a stream to get a toString()-representation
// some dangling zeros are removed and every double value ends on .0
inline std::string to_String(const double expression) {
	std::stringstream ss;
	ss << expression;
	std::string doubleValue = ss.str();
	if (doubleValue.find('.') == std::string::npos)
		return doubleValue.append(".0");
	else {
		auto positionOfCharBeforeZero = doubleValue.find_last_not_of('0');
		if ((positionOfCharBeforeZero != std::string::npos)
				&& (doubleValue[positionOfCharBeforeZero] == '.'))
			return doubleValue.erase(positionOfCharBeforeZero + 2,
					std::string::npos);
		else
			return doubleValue.erase(positionOfCharBeforeZero + 1,
					std::string::npos);
	}
}

// string values are managed by pointers, so the pointer has to be dereferenced
// if the pointer is the null pointer "null" is returned
inline std::string to_String(stringPtr ptr) {
	if (ptr == nullptr)
		return "null";
	else
		return *(ptr.get());
}

// vectors are managed by pointers, so the pointer has to be dereferenced
// if the pointer is the null pointer "null" is returned otherwise a toString()
// -representation is built with the type information and the object address
template<typename T>
inline std::string to_String(cbsLib::intrusive_ptr<cbsLib::myVector<T>> ptr) {
	if (ptr == nullptr)
		return "null";
	else {
		std::stringstream ss;
		ss << typeid(T).name() << "@" << &(*ptr.get());
		return ss.str();
	}
}
// objects are managed by pointers, so the pointer has to be dereferenced
// if the pointer is the null pointer "null" is returned otherwise a toString()
// -representation is built by calling the toString-method which every class
// has to define
template<typename T>
inline std::string to_String(cbsLib::intrusive_ptr<T> ptr) {
	if (ptr == nullptr)
		return "null";
	else
		return *(ptr.get()->toString().get());
}
#endif
