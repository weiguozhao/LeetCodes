package _java.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zhaoweiguo
 * @date 2019-12-07
 */
public class Subsets {
    /**
     * problem 78
     * https://leetcode-cn.com/problems/subsets/
     * <p>
     * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
     * <p>
     * 说明：解集不能包含重复的子集。
     * <p>
     * 示例:
     * <p>
     * 输入: nums = [1,2,3]
     * 输出:
     * [
     *   [3],
     *   [1],
     *   [2],
     *   [1,2,3],
     *   [1,3],
     *   [2,3],
     *   [1,2],
     *   []
     * ]
     */
    private List<List<Integer>> res;

    public List<List<Integer>> subsets(int[] nums) {
        res = new LinkedList<List<Integer>>();

        for (int i = 1; i <= nums.length; i++) {
            subsets(nums, i, 0, new LinkedList<>());
        }
        res.add(new LinkedList<>());
        return res;
    }

    private void subsets(int[] nums, int len, int start, LinkedList<Integer> subset) {
        if (subset.size() == len) {
            res.add(new LinkedList<>(subset));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            subset.add(nums[i]);
            subsets(nums, len, i + 1, subset);
            subset.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = new Subsets().subsets(nums);
        for (List<Integer> set : res) {
            for (Integer x : set) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
