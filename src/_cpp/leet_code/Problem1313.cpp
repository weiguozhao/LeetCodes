//
// Created by zhaowg on 2020/3/10.
//

#include "Problem1313.h"

/**
 * https://leetcode-cn.com/problems/decompress-run-length-encoded-list/
 *
    给你一个以行程长度编码压缩的整数列表 nums 。
    考虑每对相邻的两个元素 freq, val] = [nums[2*i], nums[2*i+1]] （其中 i >= 0 ），
    每一对都表示解压后子列表中有 freq 个值为 val 的元素，你需要从左到右连接所有子列表以生成解压后的列表。
    请你返回解压后的列表。

    示例：
    输入：nums = [1,2,3,4]
    输出：[2,4,4,4]
    解释：第一对 [1,2] 代表着 2 的出现频次为 1，所以生成数组 [2]。
         第二对 [3,4] 代表着 4 的出现频次为 3，所以生成数组 [4,4,4]。
         最后将它们串联到一起 [2] + [4,4,4] = [2,4,4,4]。

    示例 2：
    输入：nums = [1,1,2,3]
    输出：[1,3,3]

    提示：
    2 <= nums.length <= 100
    nums.length % 2 == 0
    1 <= nums[i] <= 100
 * */

vector<int> Problem1313::decompressRLElist(vector<int> &nums) {
  vector<int> ans;
  for (int i = 0; i < nums.size(); i += 2) {
    int freq = nums[i];
    int value = nums[i + 1];
    while (freq > 0) {
      ans.push_back(value);
      freq -= 1;
    }
  }
  return ans;
}

void Problem1313::testSolution() {
  vector<int> nums = {1, 1, 2, 3};
  auto ans = this->decompressRLElist(nums);

  for (auto n: ans) {
    cout << n << " ";
  }
}