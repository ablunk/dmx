#ifndef COUNTER_H
#define COUNTER_H

#include <string>






class Counter 
{
public:
	// Variablen	
		 int
		count
		;
		 double
		count2
		;
		 std::string
		buf
		;
	
	
	// Funktionen der Klasse	
	 int
		m
		(
		int
			 i
		)
			;
		// Konstruktoren der Klasse
	 Counter();
	Counter(const Counter& a);
	 ~Counter();
};

#endif
