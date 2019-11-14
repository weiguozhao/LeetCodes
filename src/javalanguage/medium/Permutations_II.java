package javalanguage.medium;

import java.util.*;

/**
 * @author zhaoweiguo
 * @date 2019-11-13
 */
public class Permutations_II {
    /**
     * problem 47
     * https://leetcode-cn.com/problems/permutations-ii/
     *
     * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
     *
     * 示例:
     * 输入: [1,1,2]
     * 输出:
     * [
     *   [1,1,2],
     *   [1,2,1],
     *   [2,1,1]
     * ]
     */
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        permute(nums, new boolean[nums.length], new ArrayList<>());
        return res;
    }

    private void permute(int[] nums, boolean[] visited, List<Integer> candidates) {
        if (candidates.size() == nums.length) {
            res.add(new ArrayList<>(candidates));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }

            /*
             * 使用出现的第一个值
             * 在进入一个新的分支之前，看一看这个数是不是和之前的数一样，如果这个数和之前的数一样，并且之前的数还未使用过，
             * 那接下来如果走这个分支，就会使用到之前那个和当前一样的数，就会发生重复，此时分支和之前的分支一模一样。
             * */
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }

            candidates.add(nums[i]);
            visited[i] = true;

            permute(nums, visited, candidates);

            candidates.remove(candidates.size() - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        List<List<Integer>> res = new Permutations_II().permuteUnique(nums);
        for (List<Integer> xs : res) {
            for (Integer x : xs) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
