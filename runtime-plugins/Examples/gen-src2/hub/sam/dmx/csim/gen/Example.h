#ifndef EXAMPLE_H
#define EXAMPLE_H

#include <string>





class Example 
{
public:
	// Konstruktoren der Klasse
	 Example( int
	 x,
	  std::string
	 y
	 );
	Example(const Example& a);
	 ~Example();
	
	// Attribute der Klasse	
	 int
	id
	;
	 std::string
	attribute2
	;
};

#endif
