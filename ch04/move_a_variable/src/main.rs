fn main() {
    let s1 = String::from("hello");
    let s2 = s1;

    // This will not work because s1 has been moved to s2
    println!("{s1}, world!");
}
