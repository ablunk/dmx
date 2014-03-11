## Lists

The declaration of a list `list(<type>) <name>;` is semantically the same as the declaration of a map `map(int) to <type> <name>;`.

## Maps

### Syntax

- Declaration:
	- Syntax: `'map' '(' KeyType ('<=' NumberOfKeyItems)? (',' KeyType ('<=' NumberOfKeyItems)?)* ')' 'to' ValueType ID ';'`
	- Examples:
		- `map(string,int) to bool m1;` maps a key (string,int) to a value bool
		- `map(A) to int m1;` maps a key (A) to a value int.
- Key Attributes Declaration:
	- Examples:
		- `class A { key int i; }`
- Read Access: `value = someMap.at(key1,key2)`
- Write Access:
	- Option 1: `place value into someMap at key1,key2`
	- Option 2: `someMap.at(key1,key2) = value`

## Objects

Variables of object type always contain references to objects, just like in Java.

### Nullpointer Checks

Access to object attributes via a const variable is faster as the variable does not need to be checked for NULL. All other object variables are always checked for NULL when accessed.

`const A a = new A(); a.i = 12;`
is faster than
`A a = new A(); a.i = 12; a = NULL; a.i = 12; // runtime error`