package com.wuzhenben.exceptioncheckingjava;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 1. findFirstLine(String contents)
 * 测试类型	测试描述	输入	预期结果
 * 快乐路径	输入字符串含有多行文本	"Hello\nWorld"	Optional.of("Hello")
 * 边缘情况	输入字符串仅有一行文本	"Hello"	Optional.of("Hello")
 * 快乐路径	输入字符串是空的	""	Optional.empty()
 * 不快乐路径	输入是null	null	Optional.empty()
 * 2. readFileToString(String path)
 * 测试类型	测试描述	输入	预期结果
 * 快乐路径	输入路径对应的文件存在且可以正常读取	"valid.txt"	文件内容的字符串
 * 不快乐路径	输入路径对应的文件不存在	"invalid.txt"	抛出IOException
 * 边缘情况	输入路径为空字符串	""	抛出IOException
 */
public class ExceptioncheckingjavaApplicationTest {

  @Test
  void findFirstLine_whenMultipleLinesPresent_returnsFirstLine() {
    String input = "Hello\nWorld";
    Optional<String> result = ExceptioncheckingjavaApplication.findFirstLine(input);
    assertTrue(result.isPresent(), "Result should be present");
    assertEquals("Hello", result.get(), "First line should be 'Hello'");
  }

  @Test
  void findFirstLine_whenSingleLinePresent_returnsSameLine() {
    String input = "Hello";
    Optional<String> result = ExceptioncheckingjavaApplication.findFirstLine(input);
    assertTrue(result.isPresent(), "Result should be present");
    assertEquals("Hello", result.get(), "The single line should be 'Hello'");
  }

  @Test
  void findFirstLine_whenEmptyString_returnsEmptyOptional() {
    String input = "";
    Optional<String> result = ExceptioncheckingjavaApplication.findFirstLine(input);
    assertTrue(result.isEmpty(), "Result should be empty");
  }

  @Test
  void findFirstLine_whenNullInput_returnsEmptyOptional() {
    Optional<String> result = ExceptioncheckingjavaApplication.findFirstLine(null);
    assertTrue(result.isEmpty(), "Result should be empty");
  }

  @Test
  void readFileToString_whenFileExists_returnsFileContent() throws IOException {
    String path = "hello.txt"; // Assume this file exists and can be read
    String expectedContent = "l1\nl2";
    String result = ExceptioncheckingjavaApplication.readFileToString(path);
    assertEquals(expectedContent, result, "The content should match the expected file content.");
  }

  @Test
  void readFileToString_whenFileDoesNotExist_throwsIOException() {
    String path = "invalid.txt"; // Assume this file does not exist
    assertThrows(IOException.class, () -> {
      ExceptioncheckingjavaApplication.readFileToString(path);
    }, "Should throw IOException due to file not existing.");
  }

  @Test
  void readFileToString_whenPathIsEmpty_throwsIOException() {
    String path = ""; // Path is empty
    assertThrows(IOException.class, () -> {
      ExceptioncheckingjavaApplication.readFileToString(path);
    }, "Should throw NoSuchFileException due to empty path.");
  }
}
