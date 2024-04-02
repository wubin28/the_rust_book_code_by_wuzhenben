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
  // 泛捕获异常
  try {
    std::string contents = read_file_to_string("hello.txt");
    std::cout << "File contents: " << contents << std::endl;
  } catch (...) {  // 泛捕获异常的错误在这里
    std::cerr << "An error occurred." << std::endl;
  }

  return 0;
}
