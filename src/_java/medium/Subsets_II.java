package _java.medium;

import java.util.*;

/**
 * @author zhaoweiguo
 * @date 2019-12-08
 */
public class Subsets_II {
    /**
     * problem 90
     * https://leetcode-cn.com/problems/subsets-ii/
     * <p>
     * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
     * 说明：解集不能包含重复的子集。
     * <p>
     * 示例:
     * 输入: [1,2,2]
     * 输出:
     * [
     *  [2],
     *  [1],
     *  [1,2,2],
     *  [2,2],
     *  [1,2],
     *  []
     * ]
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 1) {
            return res;
        }
        subsetsWithDup(nums, 0, new ArrayList<>(), res);
        return res;
    }

    /**
     * 解答树：
     *          1       2
     *         / \       \
     *        2   2       2
     *       /
     *      2
     * */
    private void subsetsWithDup(int[] nums, int index, List<Integer> subSet, List<List<Integer>> res) {
        res.add(new ArrayList<>(subSet));
        for (int i = index; i < nums.length; i++) {
            // 以当前value为root的子树不能再使用相同的当前值
            // i > index: 控制当前值的使用
            // nums[i] == nums[i-1]: 控制当前value为root的子树不再有value
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            subSet.add(nums[i]);
            subsetsWithDup(nums, i + 1, subSet, res);
            subSet.remove(subSet.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        List<List<Integer>> res = new Subsets_II().subsetsWithDup(nums);
        for(List<Integer> item: res) {
            for (Integer x: item) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
