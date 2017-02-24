//
//  intrusive_ptr.hpp
//
//  Copyright (c) 2001, 2002 Peter Dimov
//
// Distributed under the Boost Software License, Version 1.0. (See
// accompanying file LICENSE_1_0.txt or copy at
// http://www.boost.org/LICENSE_1_0.txt)
//
//  See http://www.boost.org/libs/smart_ptr/intrusive_ptr.html for documentation.
//

// !!THIS code was taken from Boost library and adapted to satisfy DBL needs
//  intrusive_ptr
#ifndef INTRUSIVEPTR
#define INTRUSIVEPTR

#include <cstddef>
#include <functional>
#include <ostream>

namespace cbsLib {

template<class T> class intrusive_ptr {
public:
	typedef T element_type;
	intrusive_ptr() :
			px(nullptr) {
	}
	intrusive_ptr(T* p) :
			px(p) {
		if (px != nullptr) intrusive_ptr_add_ref(px);
	}
	template<class U>
	intrusive_ptr(intrusive_ptr<U> const & rhs) :
			px(rhs.get()) {
		if (px != nullptr)
			intrusive_ptr_add_ref(px);
	}

	intrusive_ptr(intrusive_ptr const & rhs) :
			px(rhs.px) {
		if (px != nullptr)
			intrusive_ptr_add_ref(px);
	}

	virtual ~intrusive_ptr() {
		if (px != nullptr) intrusive_ptr_release(px);
	}

	template<class U>
	intrusive_ptr & operator=(intrusive_ptr<U> const & rhs) {
		intrusive_ptr(rhs).swap(*this);
		return *this;
	}

	intrusive_ptr(intrusive_ptr && rhs) :
			px(rhs.px) {
		rhs.px = nullptr;
	}

	intrusive_ptr & operator=(intrusive_ptr && rhs) {
		intrusive_ptr(static_cast<intrusive_ptr &&>(rhs)).swap(*this);
		return *this;
	}

	intrusive_ptr & operator=(intrusive_ptr const & rhs) {
		intrusive_ptr(rhs).swap(*this);
		return *this;
	}

	intrusive_ptr & operator=(T * rhs) {
		intrusive_ptr(rhs).swap(*this);
		return *this;
	}

	T * get() const {
		return px;
	}

	T * detach() {
		T * ret = px;
		px = 0;
		return ret;
	}

	T & operator*() const {
		return *px;
	}

	T * operator->() const {
		return px;
	}

	void swap(intrusive_ptr & rhs) {
		T * tmp = px;
		px = rhs.px;
		rhs.px = tmp;
	}
	protected:
	T * px;
};

template<class T, class U> inline bool operator==(intrusive_ptr<T> const & a,
		intrusive_ptr<U> const & b) {
	return a.get() == b.get();
}

template<class T, class U> inline bool operator!=(intrusive_ptr<T> const & a,
		intrusive_ptr<U> const & b) {
	return a.get() != b.get();
}

template<class T, class U> inline bool operator==(intrusive_ptr<T> const & a,
		U * b) {
	return a.get() == b;
}

template<class T, class U> inline bool operator!=(intrusive_ptr<T> const & a,
		U * b) {
	return a.get() != b;
}

template<class T, class U> inline bool operator==(T * a,
		intrusive_ptr<U> const & b) {
	return a == b.get();
}

template<class T, class U> inline bool operator!=(T * a,
		intrusive_ptr<U> const & b) {
	return a != b.get();
}

template<class T> inline bool operator==(intrusive_ptr<T> const & p,
		std::nullptr_t t) {
	return p.get() == t;
}

template<class T> inline bool operator==(std::nullptr_t t,
		intrusive_ptr<T> const & p) {
	return p.get() == t;
}

template<class T> inline bool operator!=(intrusive_ptr<T> const & p,
		std::nullptr_t t) {
	return p.get() != t;
}

template<class T> inline bool operator!=(std::nullptr_t t,
		intrusive_ptr<T> const & p) {
	return p.get() != t;
}

template<class T> inline bool operator<(intrusive_ptr<T> const & a,
		intrusive_ptr<T> const & b) {
	return std::less<T *>()(a.get(), b.get());
}

template<class T> void swap(intrusive_ptr<T> & lhs, intrusive_ptr<T> & rhs) {
	lhs.swap(rhs);
}

template<class T, class U> intrusive_ptr<T> static_pointer_cast(
		intrusive_ptr<U> const & p) {
	return static_cast<T *>(p.get());
}

template<class T, class U> intrusive_ptr<T> dynamic_pointer_cast(
		intrusive_ptr<U> const & p) {
	return dynamic_cast<T *>(p.get());
}

template<class Y> std::ostream & operator<<(std::ostream & os,
		intrusive_ptr<Y> const & p) {
	os << p.get();
	return os;
}
}
namespace std {
  template <>
  template<typename T>
  struct hash<cbsLib::intrusive_ptr<T>>
  {
    size_t operator()(const cbsLib::intrusive_ptr<T>& x) const
    {
    	return hash<T*>()(x.get());
    }
  };
}
#endif
