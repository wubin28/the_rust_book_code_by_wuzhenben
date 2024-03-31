struct MyResource {
    // Some fields
}

impl Drop for MyResource {
    fn drop(&mut self) {
        // Code to release resources or clean up
        println!("MyResource is being dropped!");
    }
}

fn main() {
    let mut s = String::from("hello"); // s is valid from this point forward

    s.push_str(", world!"); // push_str() appends a literal to a String

    println!("{s}"); // this will print `hello, world!`

    // a variable of a custom type
    let _my_resource = MyResource {}; // my_resource is valid from this point forward
                                      // do stuff with my_resource
} // Here, Rust automatically calls `drop` for `s`, releasing its memory.
