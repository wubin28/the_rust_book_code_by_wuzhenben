fn main() {
    println!("Iter Sum: {}", iter_sum());

    println!("Loop Sum: {}", loop_sum());
}

fn iter_sum() -> i32 {
    let vec = vec![1, 2, 3, 4];
    let vec_sum: i32 = vec.iter().sum();
    vec_sum
}

fn loop_sum() -> i32 {
    let vec = vec![1, 2, 3, 4];
    let mut sum = 0;
    for x in &vec {
        sum += x;
    }
    sum
}
