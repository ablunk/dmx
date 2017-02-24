#ifndef VECTORDEFINITION
#define VECTORDEFINITION
#include <vector>
#include "BaseRefCounter.h"
#include "intrusive_ptr.h"
#include <cstddef>

namespace cbsLib {
template<class T>
class myVector: public std::vector<T>, public intrusive_ref_counter<myVector<T>> {
public:
	myVector(): std::vector<T>(){}
	// creates one dimensional vector
	myVector(int size): std::vector<T>(size) {}
	// creates multidimensional vector (vector of vectors). When the inner vectors are
	// empty the outer vector is initialized with null pointer
	myVector(int size, std::nullptr_t ptr):
		std::vector<T>(size, nullptr){
	}
	// creates multidimensional vector (vector of vectors). The outer vectors are initialized
	// by copying the content of the inner vectors (deep copy needed, otherwise all outer vectors
	// point to the same inner vectors
	template<typename S>
	myVector(int size, myVector<S>* ptr) :
		std::vector<T>(make_vector(size, ptr)) {
	}
	// creates a new vector of vectors that all point to different
	// vector objects ( needs deep copy for nested vectors)
	template<typename S>
	myVector<intrusive_ptr<myVector<S>>> make_vector(int size, myVector<S>* ptr) {
		myVector<intrusive_ptr<myVector<S>>> retval;
		for(int i = 0; i < size; i++)
			retval.push_back(intrusive_ptr<myVector<S>>(new myVector<S>(ptr->begin(),ptr->end())));
		delete ptr;
		return retval;
	}
	// range based copy initialization for myVector object
	template <class InputIterator>
	myVector(InputIterator first, InputIterator last): std::vector<T>(first,last){}

	// Cast for creating new vectors based on other vectors(for primitive types)
	template<typename A>
	myVector(myVector<A>& ptr): std::vector<T>() {
		for(int i = 0; i < static_cast<int>(ptr.size()); i++) {
			this->push_back(static_cast<T>(ptr.at(i)));
		}
	}
	// Cast for reference types
	template<typename A>
	myVector(myVector<intrusive_ptr<A>>& ptr): std::vector<T>() {
		for(int i = 0; i < static_cast<int>(ptr.size()); i++) {
			this->push_back(static_pointer_cast<typename T::element_type>(ptr.at(i)));
		}
	}
	// Cast for multi-dimensional arrays, if inner dimensions are null, this is
	// done in the new vector as well
	template<typename A>
	myVector(myVector<intrusive_ptr<myVector<A>>>& ptr): std::vector<T>() {
		for(int i = 0; i < static_cast<int>(ptr.size()); i++) {
			if(ptr.at(i) == nullptr) this->push_back(nullptr);
			else this->push_back(intrusive_ptr<typename T::element_type>
				(new myVector<typename T::element_type::value_type>(*(ptr.at(i).get()))));
		}
	}
};
}
#endif
