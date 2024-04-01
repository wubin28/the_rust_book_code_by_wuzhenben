#include "lib.hpp"

auto main() -> int
{
  auto const lib = library {};

  return lib.name == "no_strict_borrow_checks_during_compilation" ? 0 : 1;
}
