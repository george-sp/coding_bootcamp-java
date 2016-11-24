// Syntax: Variables
// Create a variable with name greeting and value Hello world!
var greeting = 'Hello world!';

// Syntax: Control flow (if statements)
/*
You are provided with two variables (you don’t have to declare them):
- A number: n (you can control it’s value using the input below)
- A boolean: isZero

If the value of n equals 0, then assign the value true to isZero.
If the value of n does not equal 0, then assign the value false to isZero.
*/
var n = 0;
var isZero;

if (n === 0) {
  isZero = true;
} else if (n !== 0) {
  isZero = false;
}

// Syntax: Control flow (loops)
/*
You are provided with a variable named counter and value 0 (you don’t have to declare it).
Create either a for or a while loop that will run 5 times and will increment the value of counter by 1 during each step.
The final value of counter should be 5.
*/
var counter = 0;
for (i = 0; i < 5; i++) {
	counter++;
}

// Syntax: Functions
/*
Declare a function named cube that receives a single argument named n and returns n³.
The value of n can be controled using the input below.
*/
function cube(x) {
    return x*x*x;
}