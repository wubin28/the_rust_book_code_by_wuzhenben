cmake_minimum_required(VERSION 3.14)

include(cmake/prelude.cmake)

project(
    no_strict_borrow_checks_during_compilation
    VERSION 0.1.0
    DESCRIPTION "Short description"
    HOMEPAGE_URL "https://example.com/"
    LANGUAGES CXX
)

include(cmake/project-is-top-level.cmake)
include(cmake/variables.cmake)

# ---- Declare library ----

add_library(
    no_strict_borrow_checks_during_compilation_lib OBJECT
    source/lib.cpp
)

target_include_directories(
    no_strict_borrow_checks_during_compilation_lib ${warning_guard}
    PUBLIC
    "\$<BUILD_INTERFACE:${PROJECT_SOURCE_DIR}/source>"
)

target_compile_features(no_strict_borrow_checks_during_compilation_lib PUBLIC cxx_std_17)

# ---- Declare executable ----

add_executable(no_strict_borrow_checks_during_compilation_exe source/main.cpp)
add_executable(no_strict_borrow_checks_during_compilation::exe ALIAS no_strict_borrow_checks_during_compilation_exe)

set_property(TARGET no_strict_borrow_checks_during_compilation_exe PROPERTY OUTPUT_NAME no_strict_borrow_checks_during_compilation)

target_compile_features(no_strict_borrow_checks_during_compilation_exe PRIVATE cxx_std_17)

target_link_libraries(no_strict_borrow_checks_during_compilation_exe PRIVATE no_strict_borrow_checks_during_compilation_lib)

# ---- Install rules ----

if(NOT CMAKE_SKIP_INSTALL_RULES)
  include(cmake/install-rules.cmake)
endif()

# ---- Developer mode ----

if(NOT no_strict_borrow_checks_during_compilation_DEVELOPER_MODE)
  return()
elseif(NOT PROJECT_IS_TOP_LEVEL)
  message(
      AUTHOR_WARNING
      "Developer mode is intended for developers of no_strict_borrow_checks_during_compilation"
  )
endif()

include(cmake/dev-mode.cmake)
