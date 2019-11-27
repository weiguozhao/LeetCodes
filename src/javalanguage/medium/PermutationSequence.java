package javalanguage.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaoweiguo
 * @date 2019-11-27
 */
public class PermutationSequence {
    /**
     * problem 60
     * https://leetcode-cn.com/problems/permutation-sequence/
     * <p>
     * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
     * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
     * "123"
     * "132"
     * "213"
     * "231"
     * "312"
     * "321"
     * <p>
     * 给定 n 和 k，返回第 k 个排列。
     * <p>
     * 说明：
     * 给定 n 的范围是 [1, 9]。
     * 给定 k 的范围是[1,  n!]。
     * <p>
     * 示例 1:
     * 输入: n = 3, k = 3
     * 输出: "213"
     * <p>
     * 示例 2:
     * 输入: n = 4, k = 9
     * 输出: "2314"
     */

    /**
     * method 1
     * 全排列：将所有的排列列出来，然后取第k个
     * <p>
     * 执行结果：通过 显示详情
     * 执行用时 : 933 ms, 在所有 java 提交中击败了 5.25% 的用户
     * 内存消耗 : 103.1 MB, 在所有 java 提交中击败了 11.35% 的用户
     */
    private List<String> res;

    public String getPermutation(int n, int k) {
        int[] nums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            nums[i] = 0;
        }
        res = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        getPermutation(n, nums, stringBuilder);
        return res.get(k - 1);
    }

    private void getPermutation(int n, int[] nums, StringBuilder stringBuilder) {
        if (stringBuilder.length() == n) {
            res.add(stringBuilder.toString());
        }

        for (int i = 1; i <= n; i++) {
            if (nums[i] != 0) {
                continue;
            }
            stringBuilder.append(i);
            nums[i] = 1;
            getPermutation(n, nums, stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            nums[i] = 0;
        }
    }

    /**
     * method 2
     * 全排列剪枝优化
     */


    public static void main(String[] args) {
        int n = 4, k = 9;
        String res = new PermutationSequence().getPermutation(n, k);
        System.out.println(res);
    }
}
