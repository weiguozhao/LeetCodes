package javalanguage.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaoweiguo
 * @date 2019-11-12
 */
public class Permutations {
    /**
     * problem 46
     * https://leetcode-cn.com/problems/permutations/
     *
     * 给定一个没有重复数字的序列，返回其所有可能的全排列。
     *
     * 示例:
     * 输入: [1,2,3]
     * 输出:
     * [
     *   [1,2,3],
     *   [1,3,2],
     *   [2,1,3],
     *   [2,3,1],
     *   [3,1,2],
     *   [3,2,1]
     * ]
     */
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        permute(nums, new boolean[nums.length], new ArrayList<>());
        return res;
    }

    private void permute(int[] nums, boolean[] visited, List<Integer> candidates) {
        if (candidates.size() == nums.length) {
            res.add(new ArrayList<>(candidates));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]){
                continue;
            }
            candidates.add(nums[i]); visited[i] = true;
            permute(nums, visited, candidates);
            candidates.remove(candidates.size() - 1); visited[i] = false;
        }
    }

    /**
     * 思路：
     * 简单的回溯，不过要增加一个visited数组用来剪枝
     * */
    public static void main(String[] args) {
        int[] nums = {1, 2};
        List<List<Integer>> res = new Permutations().permute(nums);
        for (List<Integer> xs : res) {
            for (Integer x : xs) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
