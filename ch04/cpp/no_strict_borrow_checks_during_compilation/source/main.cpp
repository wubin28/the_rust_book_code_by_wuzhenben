#include <iostream>
#include <string>

#include "lib.hpp"

const int* dangling_pointer()
{
  int x = 10;
  return &x;  // 返回局部变量的地址是非法的，但C++编译器可能不会警告这个错误。
}
auto main() -> int
{
  auto const lib = library {};
  auto const message = "Hello from " + lib.name + "!";
  std::cout << message << '\n';

  // no strict borrow checks during compilation
  const int* ptr = dangling_pointer();
  std::cout << *ptr << std::endl;  // 使用悬垂指针，行为未定义。
  return 0;
}
