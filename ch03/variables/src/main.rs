use std::io;

fn main() {
    // make the variable mutable
    let mut x = 5;
    println!("The value of x is: {x}");
    x = 6;
    println!("The value of x is: {x}");

    // shadow a variable
    let x = 5;
    let x = x + 1;
    {
        let x = x * 2;
        println!("The value of x in the inner scope is: {x}");
    }
    println!("The value of x is: {x}");

    // numeric operations
    // addition
    let sum = 5 + 10;
    println!("sum: {sum}");

    // subtraction
    let difference = 95.5 - 4.3;
    println!("difference: {difference}");

    // multiplication
    let product = 4 * 30;
    println!("product: {product}");

    // division
    let quotient = 56.7 / 32.2;
    println!("quotient: {quotient}");
    // Integer division truncates toward zero to the nearest integer.
    let truncated = -5 / 3; // Results in -1
    println!("truncated: {truncated}");

    // remainder
    let remainder = 43 % 5;
    println!("remainder: {remainder}");

    // the tuple type
    let tup: (i32, f64, u8) = (500, 6.4, 1);
    // Destructure the tuple into individual variables
    let (x, y, z) = tup;
    // Print each value
    println!("The value of x is: {}", x);
    println!("The value of y is: {}", y);
    println!("The value of z is: {}", z);

    // Access the tuple elements by index
    let tup: (i32, f64, u8) = (500, 6.4, 1);
    println!("tup: ({}, {}, {})", tup.0, tup.1, tup.2);

    // Invalid Array Element Access
    let a = [1, 2, 3, 4, 5];
    println!("Please enter an array index.");
    let mut index = String::new();
    io::stdin()
        .read_line(&mut index)
        .expect("Failed to read line");
    let index: usize = index
        .trim()
        .parse()
        .expect("Index entered was not a number");
    let element = a[index];
    println!("The value of the element at index {index} is: {element}");
}
