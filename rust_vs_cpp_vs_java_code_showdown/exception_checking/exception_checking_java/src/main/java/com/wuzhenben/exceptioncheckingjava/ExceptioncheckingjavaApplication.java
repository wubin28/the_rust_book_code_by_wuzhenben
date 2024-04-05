package com.wuzhenben.exceptioncheckingjava;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ExceptioncheckingjavaApplication {

  public static void main(String[] args) {
    try {
      String contents = readFileToString("hello.txt");
      String firstLine = findFirstLine(contents);
      if (firstLine != null) {
        System.out.println("First line: " + firstLine);
      } else {
        System.out.println("File is empty or does not exist.");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  // 直接处理可能的空值，不使用 Optional
  public static String findFirstLine(String contents) {
    if (contents == null || contents.isEmpty()) {
      return null;
    } else {
      String[] lines = contents.split("\\R");
      if (lines.length > 0) {
        return lines[0];
      } else {
        return null;
      }
    }
  }

  // 尝试读取文件到字符串
  public static String readFileToString(String path) throws IOException {
    return new String(Files.readAllBytes(Paths.get(path)));
  }
}
