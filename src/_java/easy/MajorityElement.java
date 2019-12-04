package _java.easy;

import java.util.HashMap;

/**
 * @author zhaoweiguo
 * @date 2019-09-25
 */
public class MajorityElement {
    /**
     * problem 169
     * https://leetcode-cn.com/problems/majority-element/
     *
     * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
     * 你可以假设数组是非空的，并且给定的数组总是存在众数。
     *
     * 示例 1:
     * 输入: [3,2,3]
     * 输出: 3
     *
     * 示例 2:
     * 输入: [2,2,1,1,1,2,2]
     * 输出: 2
     * */

    /**
     * 借助 O(n) 空间换来 O(n)时间
     */
    public int majorityElementHashMap(int[] nums) {
        HashMap<Integer, Integer> numCount = new HashMap<>();

        for (Integer x : nums) {
            Integer count = numCount.getOrDefault(x, 0) + 1;
            numCount.put(x, count);
        }

        int res = -1;
        int count = Integer.MIN_VALUE;
        for (Integer x : numCount.keySet()) {
            if (numCount.get(x) > count) {
                count = numCount.get(x);
                res = x;
            }
        }
        return res;
    }

    /**
     * 题目限制了众数的个数：
     * 从第一个数开始，遇到相同的+1，不同-1
     * 由于众数个数 > 数组个数一半
     * https://leetcode-cn.com/problems/majority-element/solution/qiu-zhong-shu-by-leetcode-2/
     */
    public int majorityElement(int[] nums) {
        int count = 1, median = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (median == nums[i]) {
                count++;
            } else {
                count--;
                // count==0时，忘记之前的数量相等的众数和非众数
                if (count == 0) {
                    median = nums[i + 1];
                }
            }
        }
        return median;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 3};
        int median = new MajorityElement().majorityElement(nums);
        System.out.println(median);
    }
}
