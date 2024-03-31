fn main() {
    let mut s = String::from("hello"); // s is valid from this point forward

    s.push_str(", world!"); // push_str() appends a literal to a String

    println!("{s}"); // this will print `hello, world!`
} // Here, Rust automatically calls `drop` for `s`, releasing its memory.
