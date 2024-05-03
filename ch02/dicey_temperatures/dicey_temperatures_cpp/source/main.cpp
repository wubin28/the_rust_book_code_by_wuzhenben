#include <iostream>
#include <string>

int main()
{
  std::cout << "Guess the sum of two dice!\n";
  std::cout << "Please input your guess (between 2 and 12).\n";

  std::string guess;
  std::getline(std::cin, guess);

  std::cout << "You guessed: " << guess << std::endl;
  return 0;
}