//
// Created by zhaowg on 2020/3/10.
//

#include "Problem1281.h"

/**
 * https://leetcode-cn.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
 *
    给你一个整数 n，请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差。

    示例 1：
    输入：n = 234
    输出：15
    解释：
    各位数之积 = 2 * 3 * 4 = 24
    各位数之和 = 2 + 3 + 4 = 9
    结果 = 24 - 9 = 15

    示例 2：
    输入：n = 4421
    输出：21
    解释：
    各位数之积 = 4 * 4 * 2 * 1 = 32
    各位数之和 = 4 + 4 + 2 + 1 = 11
    结果 = 32 - 11 = 21

    提示：
    1 <= n <= 10^5
 * */

int Problem1281::subtractProductAndSum(int n) {
  int multi = 1, sum = 0;
  string s = to_string(n);
  for (auto ch: s) {
    multi *= ch - '0';
    sum += ch - '0';
  }
  return multi - sum;
}

void Problem1281::testSolution() {
  auto ans = this->subtractProductAndSum(4421);
  cout << ans << endl;
}