package com.wuzhenben.exceptioncheckingjava;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ExceptioncheckingjavaApplication {

  public static void main(String[] args) {
    try {
      String contents = readFileToString("hello.txt");
      String firstLine = findFirstLine(contents); // 如果contents为null，这里将抛出NullPointerException
      System.out.println("First line: " + firstLine);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // 直接处理可能的空值，不使用 Optional
  public static String findFirstLine(String contents) {
    // 不再直接处理可能的null，而是直接使用，让它在contents为null时抛出NullPointerException
    String[] lines = contents.split("\\R");
    return lines.length > 0 ? lines[0] : null; // 添加检查以避免空数组访问导致的异常
  }

  // 尝试读取文件到字符串
  public static String readFileToString(String path) throws IOException {
    Path filePath = Paths.get(path);
    // 在文件内容为空或文件不存在时显式返回null，模拟读取失败的情况
    if (Files.exists(filePath) && Files.size(filePath) > 0) {
      return new String(Files.readAllBytes(filePath));
    } else {
      return null; // 当文件不存在或为空时返回null，使得不进行null检查就会导致NullPointerException
    }
  }
}
