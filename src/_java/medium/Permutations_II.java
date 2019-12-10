package _java.medium;

import java.util.*;

/**
 * @author zhaoweiguo
 * @date 2019-11-13
 */
public class Permutations_II {
    /**
     * problem 47
     * https://leetcode-cn.com/problems/permutations-ii/
     * <p>
     * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
     * <p>
     * 示例:
     * 输入: [1,1,2]
     * 输出:
     * [
     * [1,1,2],
     * [1,2,1],
     * [2,1,1]
     * ]
     */
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        permute(nums, new boolean[nums.length], new ArrayList<>());
        return res;
    }

    /**
     * 回溯去重原理：
     * 1. 在一个数组中去掉重复元素，除了使用哈希表，更容易想到的是将原始数组排序（升序、降序均可）。
     * 2. 重复的元素一定不会是数组第 0 号索引位置的元素。因为要相同元素只保留 1 个，为了方便编码，相同元素我们保留第 1 个或者最后 1 个。
     * 3. 在遍历到相同元素的第 2 个的时候，将当前循环 continue 掉，这一步也可以认为是“剪枝操作”。
     * <p>
     * https://leetcode-cn.com/problems/permutations-ii/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liwe-2/
     */
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
             * 根节点一样，候选节点一样的部分要剪枝
             *
             * 下面if判断的含义:
             * 当前不是第一个节点 && 当前节点和前一个节点值相等 && 当前节点和前一个节点产生的候选值相同(前一个没用过<=>变成当前节点的候选值)
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
