package javalanguage.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhaoweiguo
 * @date 2019-10-25
 */
public class CombinationSum {
    /**
     * problem 39
     * https://leetcode-cn.com/problems/combination-sum/
     *
     * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     * candidates 中的数字可以无限制重复被选取。
     *
     * 说明：
     * 所有数字（包括 target）都是正整数。
     * 解集不能包含重复的组合。 
     *
     * 示例 1:
     * 输入: candidates = [2,3,6,7], target = 7,
     * 所求解集为:
     * [
     *   [7],
     *   [2,2,3]
     * ]
     *
     * 示例 2:
     * 输入: candidates = [2,3,5], target = 8,
     * 所求解集为:
     * [
     *   [2,2,2,2],
     *   [2,3,3],
     *   [3,5]
     * ]
     */
    private List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum(candidates, target, new ArrayList<>(), 0, 0);
        return res;
    }

    private void combinationSum(int[] candidate, int target, List<Integer> cands, int sum, int index) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            res.add(new ArrayList<>(cands));
            return;
        }

        for (int i = index; i < candidate.length; i++) {
            cands.add(candidate[i]);
            sum += candidate[i];
            combinationSum(candidate, target, cands, sum, i);
            cands.remove(cands.size() - 1);
            sum -= candidate[i];
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 7};
        int target = 7;

        List<List<Integer>> res = new CombinationSum().combinationSum(candidates, target);
        for (List<Integer> cands : res) {
            for (Integer x : cands) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
