fn main() {
    let mut s = String::from("hello"); // s is the owner of the string "hello"

    change(&mut s); // we borrow s as mutable to the change function

    println!("{}", s); // s is still the owner and can be used here
}

fn change(some_string: &mut String) {
    some_string.push_str(", world"); // we can modify some_string because it's a mutable borrow
}
