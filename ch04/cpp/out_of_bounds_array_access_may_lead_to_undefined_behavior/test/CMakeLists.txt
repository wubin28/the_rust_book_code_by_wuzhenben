# Parent project does not export its library target, so this CML implicitly
# depends on being added from it, i.e. the testing is done only from the build
# tree and is not feasible from an install location

project(out_of_bounds_array_access_may_lead_to_undefined_behaviorTests LANGUAGES CXX)

# ---- Tests ----

add_executable(out_of_bounds_array_access_may_lead_to_undefined_behavior_test source/out_of_bounds_array_access_may_lead_to_undefined_behavior_test.cpp)
target_link_libraries(out_of_bounds_array_access_may_lead_to_undefined_behavior_test PRIVATE out_of_bounds_array_access_may_lead_to_undefined_behavior_lib)
target_compile_features(out_of_bounds_array_access_may_lead_to_undefined_behavior_test PRIVATE cxx_std_17)

add_test(NAME out_of_bounds_array_access_may_lead_to_undefined_behavior_test COMMAND out_of_bounds_array_access_may_lead_to_undefined_behavior_test)

# ---- End-of-file commands ----

add_folders(Test)
