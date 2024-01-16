/*
Write a function 'createHelloWorld'. It should return a new
function that always returns "Hello World".

Example:
    Input: args = []
    Output: "Hello World"
*/
function createHelloWorld() {

    return function (...args): string {
        console.log("Hello World");
    };
};