#include <iostream>

#include "language_base/Annotate.h"
#include "leet_code/Problem1342.h"

int main() {
  auto solution = new Problem1342();
  solution->testSolution();

  std::cout << "#####" << std::endl;

  auto language = new Annotate();
  language->testMethod();

  return 0;
}
