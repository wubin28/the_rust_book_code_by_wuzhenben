cmake_minimum_required(VERSION 3.14)

include(cmake/prelude.cmake)

project(
    out_of_bounds_array_access_may_lead_to_undefined_behavior
    VERSION 0.1.0
    DESCRIPTION "Short description"
    HOMEPAGE_URL "https://example.com/"
    LANGUAGES CXX
)

include(cmake/project-is-top-level.cmake)
include(cmake/variables.cmake)

# ---- Declare library ----

add_library(
    out_of_bounds_array_access_may_lead_to_undefined_behavior_lib OBJECT
    source/lib.cpp
)

target_include_directories(
    out_of_bounds_array_access_may_lead_to_undefined_behavior_lib ${warning_guard}
    PUBLIC
    "\$<BUILD_INTERFACE:${PROJECT_SOURCE_DIR}/source>"
)

target_compile_features(out_of_bounds_array_access_may_lead_to_undefined_behavior_lib PUBLIC cxx_std_17)

# ---- Declare executable ----

add_executable(out_of_bounds_array_access_may_lead_to_undefined_behavior_exe source/main.cpp)
add_executable(out_of_bounds_array_access_may_lead_to_undefined_behavior::exe ALIAS out_of_bounds_array_access_may_lead_to_undefined_behavior_exe)

set_property(TARGET out_of_bounds_array_access_may_lead_to_undefined_behavior_exe PROPERTY OUTPUT_NAME out_of_bounds_array_access_may_lead_to_undefined_behavior)

target_compile_features(out_of_bounds_array_access_may_lead_to_undefined_behavior_exe PRIVATE cxx_std_17)

target_link_libraries(out_of_bounds_array_access_may_lead_to_undefined_behavior_exe PRIVATE out_of_bounds_array_access_may_lead_to_undefined_behavior_lib)

# ---- Install rules ----

if(NOT CMAKE_SKIP_INSTALL_RULES)
  include(cmake/install-rules.cmake)
endif()

# ---- Developer mode ----

if(NOT out_of_bounds_array_access_may_lead_to_undefined_behavior_DEVELOPER_MODE)
  return()
elseif(NOT PROJECT_IS_TOP_LEVEL)
  message(
      AUTHOR_WARNING
      "Developer mode is intended for developers of out_of_bounds_array_access_may_lead_to_undefined_behavior"
  )
endif()

include(cmake/dev-mode.cmake)
