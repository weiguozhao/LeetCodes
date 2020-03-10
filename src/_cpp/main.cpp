#include <iostream>

#include "language_base/Annotate.h"
#include "leet_code/Problem1281.h"

int main() {
  auto solution = new Problem1281();
  solution->testSolution();

  std::cout << std::endl << "#####" << std::endl;

  auto language = new Annotate();
  language->testMethod();

  return 0;
}
