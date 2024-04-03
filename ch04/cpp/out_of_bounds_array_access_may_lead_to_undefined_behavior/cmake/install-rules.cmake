install(
    TARGETS out_of_bounds_array_access_may_lead_to_undefined_behavior_exe
    RUNTIME COMPONENT out_of_bounds_array_access_may_lead_to_undefined_behavior_Runtime
)

if(PROJECT_IS_TOP_LEVEL)
  include(CPack)
endif()
