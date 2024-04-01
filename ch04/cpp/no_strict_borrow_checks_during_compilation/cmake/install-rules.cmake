install(
    TARGETS no_strict_borrow_checks_during_compilation_exe
    RUNTIME COMPONENT no_strict_borrow_checks_during_compilation_Runtime
)

if(PROJECT_IS_TOP_LEVEL)
  include(CPack)
endif()
