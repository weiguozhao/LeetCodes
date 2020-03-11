//
// Author: zhaowg
// Date  : 2020/3/11
//
#include <iostream>
#include "language_base/Annotate.h"
#include "leet_code/Problem771.h"

void testLanguage() {
  auto language = new Annotate();
  language->testMethod();
}

void testSolution() {
  auto solution = new Problem771();
  string J = "Z";
  string S = "ZZ";
  int ans = solution->numJewelsInStones(J, S);
  cout << ans << endl;
}

int main() {
  testSolution();
  std::cout << "-------------" << std::endl;
  testLanguage();
  return 0;
}
