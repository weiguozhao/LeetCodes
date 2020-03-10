#include "Problem1365.h"
//
// Created by Weiguo on 2020/3/7.
//

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

