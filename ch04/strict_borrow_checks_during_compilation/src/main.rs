fn main() {
    let x = 42;
    let ref_to_nothing = {
        let y = 32;
        &y
    };

    println!("{}", ref_to_nothing); // 这里会编译错误，因为y在引用离开作用域时不再存在
}
