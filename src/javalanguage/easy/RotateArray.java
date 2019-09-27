package javalanguage.easy;

/**
 * @author zhaoweiguo
 * @date 2019-09-26
 */
public class RotateArray {
    /**
     * problem 189
     * https://leetcode-cn.com/problems/rotate-array/
     */

    /**
     * 双重循环, 完全模拟手动rotate过程
     * 时间复杂度：O(kn)
     * 空间复杂度：O(1)
     */
    public void rotate_1(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        for (int i = 0; i < k; i++) {
            int temp = nums[n - 1];
            for (int j = n - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = temp;
        }
    }

    /**
     * 翻转，先整体翻转，再两个局部翻转
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public void rotate_2(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

    /**
     * 循环交换
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public void rotate_3(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        // 第一次交换完毕后，前 k 位数字位置正确，后 n-k 位数字中最后 k 位数字顺序错误，继续交换
        for (int start = 0; start < nums.length && k != 0; n -= k, start += k, k %= n) {
            for (int i = 0; i < k; i++) {
                // swap two number
                nums[start + i] += nums[nums.length - k + i];
                nums[nums.length - k + i] = nums[start + i] - nums[nums.length - k + i];
                nums[start + i] = nums[start + i] - nums[nums.length - k + i];
            }
        }
    }

    /**
     * 递归交换
     * 时间复杂度：O(n)
     * 空间复杂度：O(n/k)
     */
    public void rotate(int[] nums, int k) {
        // 原理同上
        recursiveSwap(nums, k, 0, nums.length);
    }

    private void recursiveSwap(int[] nums, int k, int start, int length) {
        k %= length;
        if (k != 0) {
            for (int i = 0; i < k; i++) {
                // swap two number
                nums[start + i] += nums[nums.length - k + i];
                nums[nums.length - k + i] = nums[start + i] - nums[nums.length - k + i];
                nums[start + i] = nums[start + i] - nums[nums.length - k + i];
            }
            recursiveSwap(nums, k, start + k, length - k);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        new RotateArray().rotate(nums, k);
        for (int x : nums) {
            System.out.println(x + " ");
        }
    }
}
