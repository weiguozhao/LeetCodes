#include <iostream>

#include "language_base/Annotate.h"
#include "leet_code/Problem1313.h"

int main() {
  auto solution = new Problem1313();
  solution->testSolution();

  std::cout << std::endl << "#####" << std::endl;

  auto language = new Annotate();
  language->testMethod();

  return 0;
}
