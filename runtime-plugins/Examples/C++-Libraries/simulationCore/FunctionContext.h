#ifndef FUNCTIONCONTEXT
#define FUNCTIONCONTEXT

// this is a base class for all function contexts used
// to save the status of interruptible functions.
// the variable state represents the function continue
// label constant, which is initially zero and changes after
// every leaving of the function
namespace cbsLib{
struct FunctionBaseContext{
	int state = 0;
	virtual ~FunctionBaseContext(){}
};
}
#endif
