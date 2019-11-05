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
