use std::fs::File;
use std::io;
use std::io::Read;

// 定义一个函数，尝试读取文件到字符串中
// 这个函数返回 Result 类型，要么是包含文件内容的 String，要么是 io::Error
fn read_file_to_string(path: &str) -> Result<String, io::Error> {
    let mut file = match File::open(path) {
        Ok(file) => file,
        Err(e) => return Err(e),
    };

    let mut contents = String::new();
    match file.read_to_string(&mut contents) {
        Ok(_) => Ok(contents),
        Err(e) => Err(e),
    }
}

// 使用 Option 类型处理可能的空值
fn find_first_line(contents: &str) -> Option<&str> {
    contents.lines().next()
}

fn main() {
    // 尝试读取一个文件
    match read_file_to_string("hello.txt") {
        Ok(contents) => {
            // 尝试找到文件的第一行
            match find_first_line(&contents) {
                Some(line) => println!("First line: {}", line),
                None => println!("File is empty"),
            }
        }
        Err(e) => println!("Error reading file: {}", e),
    }
}
