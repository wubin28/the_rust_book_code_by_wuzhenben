#include "lib.hpp"

auto main() -> int
{
  auto const lib = library {};

  return lib.name == "raii" ? 0 : 1;
}
