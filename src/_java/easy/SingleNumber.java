package _java.easy;

/**
 * @author zhaoweiguo
 * @date 2019-09-25
 */
public class SingleNumber {
    /**
     * problem 136
     * https://leetcode-cn.com/problems/single-number/
     *
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     *
     * 说明：
     * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
     *
     * 示例 1:
     * 输入: [2,2,1]
     * 输出: 1
     *
     * 示例 2:
     * 输入: [4,1,2,1,2]
     * 输出: 4
     */

    /**
     * 思路：
     * 一个数和它本身的异或为0
     * 0 和其他数的异或是数本身
     * */
    public int singleNumber(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res = res ^ nums[i];
        }
        return res;
    }

    /**
     * 数学思路：
     * 2∗(a+b+c)−(a+a+b+b+c)=c
     *
     * time: O(n)
     * space: O(n)
     * */

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 3};

        int res = new SingleNumber().singleNumber(nums);
        System.out.println(res);
    }
}
