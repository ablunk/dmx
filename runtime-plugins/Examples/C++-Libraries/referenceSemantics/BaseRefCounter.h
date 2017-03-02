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

/*
 * A reference counter base class
 *
 * This base class can be used with user-defined classes to add support
 * for intrusive_ptr. The class contains a reference counter
 * derived from the intrusive_ref_counter class, operator delete
 * is automatically called on the pointer to the object.
 *
 * The template parameter, DerivedT, is the user's class that derives from intrusive_ref_counter.
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
