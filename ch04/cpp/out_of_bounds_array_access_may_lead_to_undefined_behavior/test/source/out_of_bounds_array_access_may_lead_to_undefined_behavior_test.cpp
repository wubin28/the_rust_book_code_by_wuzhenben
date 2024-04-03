#include "lib.hpp"

auto main() -> int
{
  auto const lib = library {};

  return lib.name == "out_of_bounds_array_access_may_lead_to_undefined_behavior" ? 0 : 1;
}
