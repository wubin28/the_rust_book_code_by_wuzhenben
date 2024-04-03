# ---- Developer mode ----

# Developer mode enables targets and code paths in the CMake scripts that are
# only relevant for the developer(s) of out_of_bounds_array_access_may_lead_to_undefined_behavior
# Targets necessary to build the project must be provided unconditionally, so
# consumers can trivially build and package the project
if(PROJECT_IS_TOP_LEVEL)
  option(out_of_bounds_array_access_may_lead_to_undefined_behavior_DEVELOPER_MODE "Enable developer mode" OFF)
endif()

# ---- Warning guard ----

# target_include_directories with the SYSTEM modifier will request the compiler
# to omit warnings from the provided paths, if the compiler supports that
# This is to provide a user experience similar to find_package when
# add_subdirectory or FetchContent is used to consume this project
set(warning_guard "")
if(NOT PROJECT_IS_TOP_LEVEL)
  option(
      out_of_bounds_array_access_may_lead_to_undefined_behavior_INCLUDES_WITH_SYSTEM
      "Use SYSTEM modifier for out_of_bounds_array_access_may_lead_to_undefined_behavior's includes, disabling warnings"
      ON
  )
  mark_as_advanced(out_of_bounds_array_access_may_lead_to_undefined_behavior_INCLUDES_WITH_SYSTEM)
  if(out_of_bounds_array_access_may_lead_to_undefined_behavior_INCLUDES_WITH_SYSTEM)
    set(warning_guard SYSTEM)
  endif()
endif()
