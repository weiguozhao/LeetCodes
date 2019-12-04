package _java.medium;

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
     * 根据 阶乘 的分布，直接计算个数
     *
     * 例：n= 3, k = 4
     *
     *     1         2          3
     *    / \      /  \       /  \
     *   2  3     1   3      1    2
     *  /   \    /    \     /     \
     * 3    2   3      1    2     1
     *
     * k=4, answer="231"
     * root=1 有 (n-1)! = 2 个值
     * root=2 有 (n-1)! = 2 个值
     * root=3 有 (n-1)! = 2 个值
     *
     * 同理，对于一个节点下方有 (n-1)! 个值，直接根据这个 (n-1)! 个值进行计算
     *
     * 执行结果：通过 显示详情
     * 执行用时 : 1 ms, 在所有 java 提交中击败了 100.00% 的用户
     * 内存消耗 : 34 MB, 在所有 java 提交中击败了 91.93% 的用户
     */

    /**
     * factor[0] = 1 是为了控制最后一位数加入到 StringBuilder 中
     * */
    private int[] factor = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};

    public String getPermutationCut(int n, int k) {
        StringBuilder stringBuilder = new StringBuilder();
        int[] nums = new int[n + 1];
        getPermutationCut(n, n, k, nums, stringBuilder);
        return stringBuilder.toString();
    }


    private void getPermutationCut(int originN, int n, int k, int[] nums, StringBuilder stringBuilder) {

        for (int i = 1; i <= originN; i++) {
            if (nums[i] != 0) {
                continue;
            }
            if (k - factor[n - 1] <= 0) {
                stringBuilder.append(i);
                nums[i] = 1;
                break;
            }
            k -= factor[n - 1];
        }
        if (n > 0) {
            getPermutationCut(originN, n - 1, k, nums, stringBuilder);
        }
    }

    public static void main(String[] args) {
        int n = 4, k = 5;
        String res = new PermutationSequence().getPermutationCut(n, k);
        String answer = new PermutationSequence().getPermutation(n, k);
        System.out.println(res);
        System.out.println(answer);
    }
}
