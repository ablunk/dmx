/*
 *          Copyright Andrey Semashev 2007 - 2013.
 * Distributed under the Boost Software License, Version 1.0.
 *    (See accompanying file LICENSE_1_0.txt or copy at
 *          http://www.boost.org/LICENSE_1_0.txt)
 */
/*!
 * \file   intrusive_ref_counter.hpp
 * \author Andrey Semashev
 * \date   12.03.2009
 *
 * This header contains a reference counter class for \c intrusive_ptr.
 */

// This Code was taken from Boost Library to enable intrusive reference counting and adapted to satisfy
// the needs of DBL
#ifndef BASEREFCOUNTER
#define BASEREFCOUNTER

namespace cbsLib {


template<typename DerivedT>
class intrusive_ref_counter;

template<typename DerivedT>
void intrusive_ptr_add_ref(const intrusive_ref_counter<DerivedT>* p);
template< typename DerivedT>
void intrusive_ptr_sub_ref(const intrusive_ref_counter<DerivedT>* p);
template< typename DerivedT>
void intrusive_ptr_release(const intrusive_ref_counter<DerivedT>* p);

/*!
 * \brief A reference counter base class
 *
 * This base class can be used with user-defined classes to add support
 * for \c intrusive_ptr. The class contains a reference counter defined by the \c CounterPolicyT.
 * Upon releasing the last \c intrusive_ptr referencing the object
 * derived from the \c intrusive_ref_counter class, operator \c delete
 * is automatically called on the pointer to the object.
 *
 * The other template parameter, \c DerivedT, is the user's class that derives from \c intrusive_ref_counter.
 */
template<typename DerivedT>
class intrusive_ref_counter
{
private:
   mutable unsigned int m_ref_counter;
public:
    intrusive_ref_counter():m_ref_counter(0){}
    intrusive_ref_counter(intrusive_ref_counter const&):m_ref_counter(0){}
    intrusive_ref_counter& operator= (intrusive_ref_counter const&) {return *this;}
    unsigned int use_count() const {return m_ref_counter;}
protected:
    virtual ~intrusive_ref_counter(){}
    friend void intrusive_ptr_add_ref<DerivedT>(const intrusive_ref_counter<DerivedT>* p);
    friend void intrusive_ptr_release<DerivedT>(const intrusive_ref_counter<DerivedT>* p);
    friend void intrusive_ptr_sub_ref<DerivedT>(const intrusive_ref_counter<DerivedT>* p);
};

template<typename DerivedT>
inline void intrusive_ptr_add_ref(const intrusive_ref_counter<DerivedT>* p)
{
    ++(p->m_ref_counter);
}

template<typename DerivedT>
inline void intrusive_ptr_sub_ref(const intrusive_ref_counter<DerivedT>* p)
{
   --(p->m_ref_counter);
}

template<typename DerivedT>
inline void intrusive_ptr_release(const intrusive_ref_counter<DerivedT>* p)
{
    if (--(p->m_ref_counter) == 0) delete static_cast<const DerivedT*>(p);
}

}
#endif
