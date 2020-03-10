//
// Created by Weiguo on 2020/3/7.
//
#include "Problem1365.h"

std::vector<int> Problem1365::smallerNumbersThanCurrent(std::vector<int> &nums) {
  int count[101];
  std::memset(count, 0, sizeof(count));
  for (int num: nums) {
    count[num]++;
  }

  int pre_sum = count[0];
  for (int i = 1; i < 101; i++) {
    int current_value = count[i];
    count[i] = pre_sum;
    pre_sum += current_value;
  }

  std::vector<int> ans;
  for (int num: nums) {
    ans.push_back(count[num]);
  }

  return ans;
}

void Problem1365::testSolution() {
  std::vector<int> nums = {8, 1, 2, 2, 3};
  auto solution = new Problem1365();
  std::vector<int> ans = solution->smallerNumbersThanCurrent(nums);

  for (auto n: ans) {
    std::cout << n << " ";
  }
}

