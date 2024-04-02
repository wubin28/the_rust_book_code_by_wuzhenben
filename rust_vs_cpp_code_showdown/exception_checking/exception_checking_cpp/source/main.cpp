#include <fstream>
#include <iostream>
#include <string>

#include "lib.hpp"

std::string read_file_to_string(const std::string& path)
{
  std::ifstream file(path);
  if (!file.is_open()) {
    throw std::runtime_error("Could not open file");
  }

  std::string contents((std::istreambuf_iterator<char>(file)),
                       std::istreambuf_iterator<char>());
  return contents;
}

auto main() -> int
{
  // 捕获特定类型的异常
  try {
    std::string contents = read_file_to_string("hello.txt");
    std::cout << "File contents: " << contents << std::endl;
  } catch (const std::runtime_error& e) {  // 改为捕获特定类型的异常
    std::cerr << "Error reading file: " << e.what() << std::endl;
  } catch (const std::exception& e) {  // 捕获所有标准异常的基类
    std::cerr << "Standard error: " << e.what() << std::endl;
  } catch (...) {  // 最后，用泛捕获来处理其他不可预见的异常
    std::cerr << "An unknown error occurred." << std::endl;
  }

  return 0;
}
