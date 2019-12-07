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
