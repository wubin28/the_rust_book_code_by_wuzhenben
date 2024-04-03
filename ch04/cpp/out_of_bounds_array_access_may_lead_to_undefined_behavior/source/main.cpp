#include <iostream>
#include <string>

#include "lib.hpp"

auto main() -> int
{
  auto const lib = library {};
  auto const message = "Hello from " + lib.name + "!";
  std::cout << message << '\n';

  int arr[3] = {1, 2, 3};
  std::cout << arr[10] << std::endl;  // 越界访问，导致未定义行为。

  return 0;
}
