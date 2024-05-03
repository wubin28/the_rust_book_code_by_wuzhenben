package com.wuzhenben.diceytemperatures;

import java.util.Scanner;

public class GuessTheSum {
  public static void main(String[] args) {
    System.out.println("Guess the sum of two dice!");
    System.out.println("Please input your guess (between 2 and 12).");

    Scanner scanner = new Scanner(System.in);
    String guess = scanner.nextLine();
    scanner.close();

    System.out.println("You guessed: " + guess);
  }
}
