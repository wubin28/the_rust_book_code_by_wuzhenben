fn main() {
    println!("Hello, world!");
    another_function(5);
    print_labeled_measurement(5, 'h');
}

fn another_function(i: i32) {
    println!("The value of i is: {}", i);
}

fn print_labeled_measurement(value: i32, unit_label: char) {
    println!("The value of the measurement is: {}{}", value, unit_label);
}
