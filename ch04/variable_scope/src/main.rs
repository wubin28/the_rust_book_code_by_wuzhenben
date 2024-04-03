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
                                      // Ownership of _my_resource is moved to _my_resource_2
    let _my_resource_2 = _my_resource; // After this point, _my_resource is no longer valid

    // let _my_resource_3 = _my_resource; // This will throw an error because _my_resource is no longer valid

    // do stuff with _my_resource_2
} // Here, Rust automatically calls `drop` for `s` and `_my_resource_2` only once, releasing its memory.
