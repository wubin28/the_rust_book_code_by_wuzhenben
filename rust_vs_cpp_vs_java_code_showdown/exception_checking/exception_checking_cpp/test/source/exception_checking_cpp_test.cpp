#include "lib.hpp"

auto main() -> int
{
  auto const lib = library {};

  return lib.name == "exception_checking_cpp" ? 0 : 1;
}
