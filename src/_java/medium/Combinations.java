package _java.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhaoweiguo
 * @date 2019-12-05
 */
public class Combinations {
    /**
     * problem 77
     * https://leetcode-cn.com/problems/combinations/
     * <p>
     * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
     * <p>
     * 示例:
     * 输入: n = 4, k = 2
     * 输出:
     * [
     * [2,4],
     * [3,4],
     * [2,3],
     * [1,2],
     * [1,3],
     * [1,4],
     * ]
     */


    /**
     * 回溯法：
     * 注意满足要求的时候剪枝
     */
    private List<List<Integer>> res;

    public List<List<Integer>> combine(int n, int k) {
        res = new LinkedList<>();
        combine(n, k, 1, new LinkedList<>());
        return res;
    }

    private void combine(int n, int k, int start, LinkedList<Integer> ans) {
        if (ans.size() == k) {
            res.add(new ArrayList<>(ans));
            return;
        }

        for (int i = start; i <= n; i++) {
            ans.add(i);
            combine(n, k, i + 1, ans);
            ans.removeLast();
        }
    }

    /**
     * 字典序 (二进制排序) 组合
     */
    public List<List<Integer>> combine2(int n, int k) {
        // init first combination
        LinkedList<Integer> nums = new LinkedList<>();
        for (int i = 1; i < k + 1; ++i) {
            nums.add(i);
        }
        nums.add(n + 1);

        List<List<Integer>> output = new ArrayList<>();
        int j = 0;
        while (j < k) {
            // add current combination
            output.add(new LinkedList(nums.subList(0, k)));
            // increase first nums[j] by one
            // if nums[j] + 1 != nums[j + 1]
            j = 0;
            while ((j < k) && (nums.get(j + 1) == nums.get(j) + 1)) {
                nums.set(j, j++ + 1);
            }
            nums.set(j, nums.get(j) + 1);
        }
        return output;
    }

    public static void main(String[] args) {
        int n = 4, k = 2;
        List<List<Integer>> res = new Combinations().combine(n, k);
        for (List<Integer> item : res) {
            for (Integer x : item) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
