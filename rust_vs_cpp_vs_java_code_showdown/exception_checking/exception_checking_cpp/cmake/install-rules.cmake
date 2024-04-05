install(
    TARGETS exception_checking_cpp_exe
    RUNTIME COMPONENT exception_checking_cpp_Runtime
)

if(PROJECT_IS_TOP_LEVEL)
  include(CPack)
endif()
