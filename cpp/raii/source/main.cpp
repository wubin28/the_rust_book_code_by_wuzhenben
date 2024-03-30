#include <fstream>
#include <iostream>
#include <string>

#include "lib.hpp"

class FileWrapper
{
public:
  FileWrapper(const char* filename)
  {
    // 在构造函数中打开文件
    std::cout << "Opening file: " << filename << std::endl;
    file.open(filename);
    if (file.is_open()) {
      std::cout << "File opened successfully." << std::endl;
    } else {
      std::cout << "Failed to open file." << std::endl;
    }
  }

  ~FileWrapper()
  {
    // 在析构函数中关闭文件
    if (file.is_open()) {
      std::cout << "Closing file." << std::endl;
      file.close();
      std::cout << "File closed successfully." << std::endl;
    }
  }

  // 禁止拷贝构造函数和拷贝赋值操作，确保文件资源的唯一性
  FileWrapper(const FileWrapper&) = delete;
  FileWrapper& operator=(const FileWrapper&) = delete;

  // 允许移动构造函数和移动赋值操作，支持资源的安全转移
  FileWrapper(FileWrapper&&) noexcept = default;
  FileWrapper& operator=(FileWrapper&&) noexcept = default;

  // 使用文件的操作
  void write(const std::string& message)
  {
    if (file.is_open()) {
      file << message << std::endl;
    }
  }

private:
  std::ofstream file;  // 文件句柄
};

FileWrapper createFileWrapper();

auto main() -> int
{
  auto const lib = library {};
  auto const message = "Hello from " + lib.name + "!";
  std::cout << message << '\n';

  // RAII Demo
  {
    FileWrapper fw("example.txt");

    // 禁止拷贝构造函数(Copy Constructor)，编译错误
    // FileWrapper fw2 = fw;

    // 禁止拷贝赋值操作(Copy Assignment Operator)，编译错误
    // FileWrapper fw2("example2.txt");
    // fw2 = fw;

    // 允许移动构造函数(Move Constructor)，资源转移
    // Here, the move constructor is called.
    FileWrapper fw1 = createFileWrapper();

    // 允许移动赋值操作(Move Assignment Operator)，资源转移
    FileWrapper fw2("example2.txt");
    FileWrapper fw3("example3.txt");
    // This would call the move assignment operator, and it's allowed in the
    // FileWrapper class.
    fw3 = std::move(fw2);

    fw.write("Hello, RAII!");
    // fw的生命周期结束时，其析构函数会自动被调用，文件被关闭
  }  // fw析构函数在这里被调用

  // 此时文件已经被关闭，无需手动关闭文件
  std::cout << "File has been closed." << std::endl;

  return 0;
}

FileWrapper createFileWrapper()
{
  FileWrapper fw("example1.txt");
  return fw;  // This would call the move constructor, and it's allowed in the
              // FileWrapper class.
}