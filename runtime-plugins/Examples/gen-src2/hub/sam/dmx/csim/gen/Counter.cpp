#include "Counter.h"







// Funktionen der Klasse	
 int
	Counter::
	m
	(
	int
		 i
	)
		{if ((
	i
	<=1)) return 
	i
	;
	return (
	m
	(
		(
		i
		-1)
					)
	+
	m
	(
		(
		i
		-2)
					)
	);
	}
	// Konstruktoren der Klasse
 Counter::Counter()
				: 
				 count(
					 0
										)
					,
				count2(
					 5
										)
					,
				buf(
					 "hello"
										)
				{};
Counter::Counter(const Counter& a) = default;
Counter::~Counter() {}
