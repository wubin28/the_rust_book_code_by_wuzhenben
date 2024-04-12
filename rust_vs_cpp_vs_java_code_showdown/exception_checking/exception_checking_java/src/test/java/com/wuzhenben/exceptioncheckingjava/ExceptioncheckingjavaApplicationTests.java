package com.wuzhenben.exceptioncheckingjava;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;
import org.junit.jupiter.api.Test;

class ExceptioncheckingjavaApplicationTests {

  @Test
  void testFindFirstLine() {
    String testString = "Hello\nWorld";
    Optional<String> result = ExceptioncheckingjavaApplication.findFirstLine(testString);
    assertTrue(result.isPresent());

    assertEquals("Hello", result.get());

    Optional<String> emptyResult = ExceptioncheckingjavaApplication.findFirstLine(null);
    assertFalse(emptyResult.isPresent());
  }
}
