cmake_minimum_required(VERSION 3.14)

include(cmake/prelude.cmake)

project(
    exception_checking_cpp
    VERSION 0.1.0
    DESCRIPTION "Short description"
    HOMEPAGE_URL "https://example.com/"
    LANGUAGES CXX
)

include(cmake/project-is-top-level.cmake)
include(cmake/variables.cmake)

# ---- Declare library ----

add_library(
    exception_checking_cpp_lib OBJECT
    source/lib.cpp
)

target_include_directories(
    exception_checking_cpp_lib ${warning_guard}
    PUBLIC
    "\$<BUILD_INTERFACE:${PROJECT_SOURCE_DIR}/source>"
)

target_compile_features(exception_checking_cpp_lib PUBLIC cxx_std_17)

# ---- Declare executable ----

add_executable(exception_checking_cpp_exe source/main.cpp)
add_executable(exception_checking_cpp::exe ALIAS exception_checking_cpp_exe)

set_property(TARGET exception_checking_cpp_exe PROPERTY OUTPUT_NAME exception_checking_cpp)

target_compile_features(exception_checking_cpp_exe PRIVATE cxx_std_17)

target_link_libraries(exception_checking_cpp_exe PRIVATE exception_checking_cpp_lib)

# ---- Install rules ----

if(NOT CMAKE_SKIP_INSTALL_RULES)
  include(cmake/install-rules.cmake)
endif()

# ---- Developer mode ----

if(NOT exception_checking_cpp_DEVELOPER_MODE)
  return()
elseif(NOT PROJECT_IS_TOP_LEVEL)
  message(
      AUTHOR_WARNING
      "Developer mode is intended for developers of exception_checking_cpp"
  )
endif()

include(cmake/dev-mode.cmake)
