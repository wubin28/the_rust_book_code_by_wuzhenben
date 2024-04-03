fn main() {
    let v = vec![1, 2, 3];
    println!("{}", v[10]); // 这将在编译时通过，但在运行时引发panic，避免了未定义行为
}
