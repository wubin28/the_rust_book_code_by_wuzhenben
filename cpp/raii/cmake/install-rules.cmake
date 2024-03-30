install(
    TARGETS raii_exe
    RUNTIME COMPONENT raii_Runtime
)

if(PROJECT_IS_TOP_LEVEL)
  include(CPack)
endif()
