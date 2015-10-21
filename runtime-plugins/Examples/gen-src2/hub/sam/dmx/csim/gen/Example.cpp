#include "Example.h"
#include <iostream>



// Konstruktoren der Klasse
 Example::Example( int
 x,
  std::string
 y
 )
				: 
				 id(
				
				x
				)
				,
				attribute2(
				
				y
				)
				{
					std::cout <<
					y<<
					" Example, ID: "<<
					id
					<< std::endl;
				}
Example::Example(const Example& a) = default;
Example::~Example() = default;

// Attribute der Klasse	
 int
id
 { 
0
				};
 std::string
attribute2
 { 
""
				};
