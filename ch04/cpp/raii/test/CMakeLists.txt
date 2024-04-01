# Parent project does not export its library target, so this CML implicitly
# depends on being added from it, i.e. the testing is done only from the build
# tree and is not feasible from an install location

project(raiiTests LANGUAGES CXX)

# ---- Tests ----

add_executable(raii_test source/raii_test.cpp)
target_link_libraries(raii_test PRIVATE raii_lib)
target_compile_features(raii_test PRIVATE cxx_std_17)

add_test(NAME raii_test COMMAND raii_test)

# ---- End-of-file commands ----

add_folders(Test)
