fn main() {
    println!("Hello, world!");
    another_function(5);
    print_labeled_measurement(5, 'h');

    let x = five();
    println!("The value of x is: {}", x);

    // Using if in a let Statement
    let condition = true;
    let number = if condition { 5 } else { 6 };

    println!("The value of number is: {number}");
}

fn another_function(i: i32) {
    println!("The value of i is: {}", i);
}

fn print_labeled_measurement(value: i32, unit_label: char) {
    println!("The value of the measurement is: {}{}", value, unit_label);
}

fn five() -> i32 {
    5
}
