# Parent project does not export its library target, so this CML implicitly
# depends on being added from it, i.e. the testing is done only from the build
# tree and is not feasible from an install location

project(exception_checking_cppTests LANGUAGES CXX)

# ---- Tests ----

add_executable(exception_checking_cpp_test source/exception_checking_cpp_test.cpp)
target_link_libraries(exception_checking_cpp_test PRIVATE exception_checking_cpp_lib)
target_compile_features(exception_checking_cpp_test PRIVATE cxx_std_17)

add_test(NAME exception_checking_cpp_test COMMAND exception_checking_cpp_test)

# ---- End-of-file commands ----

add_folders(Test)
