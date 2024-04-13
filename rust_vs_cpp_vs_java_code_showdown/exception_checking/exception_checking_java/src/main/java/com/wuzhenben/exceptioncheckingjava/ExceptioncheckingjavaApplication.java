package com.wuzhenben.exceptioncheckingjava;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExceptioncheckingjavaApplication {
  private static Logger LOGGER = Logger.getLogger(ExceptioncheckingjavaApplication.class.getName());

  public static void main(String[] args) {
    try {
      String contents = readFileToString("hello.txt");
      findFirstLine(contents)
          .ifPresentOrElse(
              line -> LOGGER.log(Level.INFO, "First line: " + line),
              () -> LOGGER.log((Level.INFO), "File is empty"));
    } catch (IOException e) {
      LOGGER.log(Level.SEVERE, "Error reading file: " + e.getMessage());
    }
  }

  // 使用 Optional 类型处理可能的空值
  public static Optional<String> findFirstLine(String contents) {
    return Optional.ofNullable(contents).flatMap(c -> c.lines().findFirst());
  }

  // 尝试读取文件到字符串
  public static String readFileToString(String path) throws IOException {
    return new String(Files.readAllBytes(Paths.get(path)));
  }
}
