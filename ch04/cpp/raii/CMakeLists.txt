cmake_minimum_required(VERSION 3.14)

include(cmake/prelude.cmake)

project(
    raii
    VERSION 0.1.0
    DESCRIPTION "A C++ RAII Demo"
    HOMEPAGE_URL "https://example.com/"
    LANGUAGES CXX
)

include(cmake/project-is-top-level.cmake)
include(cmake/variables.cmake)

# ---- Declare library ----

add_library(
    raii_lib OBJECT
    source/lib.cpp
)

target_include_directories(
    raii_lib ${warning_guard}
    PUBLIC
    "\$<BUILD_INTERFACE:${PROJECT_SOURCE_DIR}/source>"
)

target_compile_features(raii_lib PUBLIC cxx_std_17)

# ---- Declare executable ----

add_executable(raii_exe source/main.cpp)
add_executable(raii::exe ALIAS raii_exe)

set_property(TARGET raii_exe PROPERTY OUTPUT_NAME raii)

target_compile_features(raii_exe PRIVATE cxx_std_17)

target_link_libraries(raii_exe PRIVATE raii_lib)

# ---- Install rules ----

if(NOT CMAKE_SKIP_INSTALL_RULES)
  include(cmake/install-rules.cmake)
endif()

# ---- Developer mode ----

if(NOT raii_DEVELOPER_MODE)
  return()
elseif(NOT PROJECT_IS_TOP_LEVEL)
  message(
      AUTHOR_WARNING
      "Developer mode is intended for developers of raii"
  )
endif()

include(cmake/dev-mode.cmake)
