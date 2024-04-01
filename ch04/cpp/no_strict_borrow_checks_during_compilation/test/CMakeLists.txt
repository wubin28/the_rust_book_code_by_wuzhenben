# Parent project does not export its library target, so this CML implicitly
# depends on being added from it, i.e. the testing is done only from the build
# tree and is not feasible from an install location

project(no_strict_borrow_checks_during_compilationTests LANGUAGES CXX)

# ---- Tests ----

add_executable(no_strict_borrow_checks_during_compilation_test source/no_strict_borrow_checks_during_compilation_test.cpp)
target_link_libraries(no_strict_borrow_checks_during_compilation_test PRIVATE no_strict_borrow_checks_during_compilation_lib)
target_compile_features(no_strict_borrow_checks_during_compilation_test PRIVATE cxx_std_17)

add_test(NAME no_strict_borrow_checks_during_compilation_test COMMAND no_strict_borrow_checks_during_compilation_test)

# ---- End-of-file commands ----

add_folders(Test)
