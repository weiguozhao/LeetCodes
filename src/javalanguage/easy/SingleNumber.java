package javalanguage.easy;

/**
 * @author zhaoweiguo
 * @date 2019-09-25
 */
public class SingleNumber {
    /**
     * problem 136
     * https://leetcode-cn.com/problems/single-number/
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
