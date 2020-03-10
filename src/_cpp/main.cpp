#include <iostream>

#include "language_base/MathFunctions.h"

#include "leet_code/Problem1365.h"

int main() {
  std::vector<int> nums = {8, 1, 2, 2, 3};
  auto solution = new Problem1365();
  std::vector<int> ans = solution->smallerNumbersThanCurrent(nums);

  for (auto n: ans) {
    std::cout << n << " ";
  }
  return 0;
}
