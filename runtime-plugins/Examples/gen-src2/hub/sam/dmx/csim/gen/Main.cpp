#include "Example.h"
// import header files standard library
#include <iostream>
#include <ctime>
int main()
{
float elapsed;
clock_t start = clock();
	Example
				* e
					{new Example
						(
							1, 
							"hi" 
						)
					}
					;
delete e;
elapsed = (float)(clock() - start) / CLOCKS_PER_SEC;
std::cout << "Overall execution time: " << elapsed << " sec." << std::endl;

return 0;
}
