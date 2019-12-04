package _java.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhaoweiguo
 * @date 2019-10-25
 */
public class CombinationSum_II {
    /**
     * problem 40
     * https://leetcode-cn.com/problems/combination-sum-ii/
     *
     * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     * candidates 中的每个数字在每个组合中只能使用一次。
     *
     * 说明：
     * 所有数字（包括目标数）都是正整数。
     * 解集不能包含重复的组合。
     *  
     * 示例 1:
     * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
     * 所求解集为:
     * [
     *   [1, 7],
     *   [1, 2, 5],
     *   [2, 6],
     *   [1, 1, 6]
     * ]
     *
     * 示例 2:
     * 输入: candidates = [2,5,2,1,2], target = 5,
     * 所求解集为:
     * [
     *   [1,2,2],
     *   [5]
     * ]
     */
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum2(candidates, target, new ArrayList<>(), 0, 0);
        return res;
    }

    private void combinationSum2(int[] candidate, int target, List<Integer> cands, int sum, int index) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            res.add(new ArrayList<>(cands));
            return;
        }

        for (int i = index; i < candidate.length; i++) {
            /*
             * 注意这里用 i>index，而不能用 i>0，因为要保证candidatge中的每个数都有机会被用到
             * */
            if (i > index && candidate[i] == candidate[i - 1]) {
                continue;
            }
            cands.add(candidate[i]);
            sum += candidate[i];
            combinationSum2(candidate, target, cands, sum, i + 1);
            cands.remove(cands.size() - 1);
            sum -= candidate[i];
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;

        List<List<Integer>> res = new CombinationSum_II().combinationSum2(candidates, target);
        for (List<Integer> comb : res) {
            for (Integer x : comb) {
                System.out.print(x + " ");
            }
            System.out.print("\n");
        }
    }
}
