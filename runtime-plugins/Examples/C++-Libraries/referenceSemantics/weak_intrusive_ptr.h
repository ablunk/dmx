#ifndef WEAKINTRUSIVEPTR
#define WEAKINTRUSIVEPTR

#include "intrusive_ptr.h"
// weak intrusive pointer are needed if the object should not be deleted
// e.g. when this-pointer is used in constructors, when reference count is still
// zero and after changing the counter to one and again to zero, the object shouldn't
// be removed. This is done by decreasing the reference counter and setting the pointer
// to null pointer to avoid the destructor call of the base class
namespace cbsLib {
template<class T>
class weak_intrusive_ptr : public intrusive_ptr<T>{
	public:
	weak_intrusive_ptr(T* p): intrusive_ptr<T>(p){}
	~weak_intrusive_ptr(){
		if (intrusive_ptr<T>::px != nullptr) intrusive_ptr_sub_ref(intrusive_ptr<T>::px);
		intrusive_ptr<T>::px = nullptr;
	}
};
}
#endif
