//
// Author: zhaowg
// Date  : 2020/3/11
//
#include <iostream>
#include "language_base/Annotate.h"
#include "leet_code/Problem1108.h"

void testLanguage() {
  auto language = new Annotate();
  language->testMethod();
}

void testSolution() {
  auto solution = new Problem1108();
  string s = "1.1.1.1";
  auto ans = solution->defangIPaddr(s);
  cout << ans << endl;
}

int main() {
  testSolution();
  std::cout << "-------------" << std::endl;
  testLanguage();
  return 0;
}
