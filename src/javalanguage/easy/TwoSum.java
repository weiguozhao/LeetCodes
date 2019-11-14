package javalanguage.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhaoweiguo
 * @date 2019-09-13
 */
public class TwoSum {
    /**
     * problem 1.
     * https://leetcode-cn.com/problems/two-sum/
     * <p>
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * <p>
     * 示例：
     * <p>
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer rest = target - nums[i];

            if (numIndex.containsKey(rest)) {
                return new int[]{numIndex.get(rest), i};
            }

            numIndex.put(nums[i], i);
        }

        throw new IllegalArgumentException("No twoSum Solution.");
    }

    /**
     * 思考：本题是两数之和，如果是k个数之和呢？如果是有序数组呢？
     * <p>
     * k数之和：
     * <p>
     * 有序数组的两数之和：
     * 从两端到中间挤 O(n)
     * <p>
     * 有序数组的k数之和：
     */

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        TwoSum obj = new TwoSum();
        int[] res = obj.twoSum(nums, target);

        for (int i : res) {
            System.out.println(i);
        }
    }
}
