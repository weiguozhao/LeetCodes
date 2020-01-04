package _java.hard;

/**
 * @author zhaoweiguo
 * @date 2020-01-04
 */
public class FirstMissingPositive {
    /**
     * problem 41
     * https://leetcode-cn.com/problems/first-missing-positive/
     * <p>
     * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
     * <p>
     * 示例 1:
     * 输入: [1,2,0]
     * 输出: 3
     * <p>
     * 示例 2:
     * 输入: [3,4,-1,1]
     * 输出: 2
     * <p>
     * 示例 3:
     * 输入: [7,8,9,11,12]
     * 输出: 1
     */

    /**
     * 自身做bitmap
     */
    public int firstMissingPositive(int[] nums) {
        int length = nums.length, left = 0, right = length - 1;

        // 先检查数组中是否包含1，后续要将0和负数重置为1
        boolean contains = false;
        for (int i = 0; i < length; i++) {
            if (nums[i] == 1) {
                contains = true;
                break;
            }
        }

        if (!contains) {
            // 不包含1
            return 1;
        }
        if (length == 1)  {
            // nums = [1], 数组只包含一个值
            return 2;
        }

        // 用1替换负数、0和大于n的数，在转换以后nums中只会包含正数
        for (int i = 0; i < length; i++) {
            if ((nums[i] <= 0) || (nums[i] > length)) {
                nums[i] = 1;
            }
        }

        // 使用索引和数字符号作为检查器，负数表示存在，正数表示不存在，数字length存在与否用index=0的值正负表示
        // 例如，如果 nums[1] 是负数表示在数组中出现了数字 1；如果 nums[2] 是正数 表示数字 2 没有出现
        for (int i = 0; i < length; i++) {
            int a = Math.abs(nums[i]) % length;
            if (nums[a] < 0) {
                // 数字a已经标记存在过了
                continue;
            }
            // 标记数字a存在，改变第a个元素(index=a-1)的符号
            nums[a] *= -1;
        }

        // 现在第一个正数的下标，就是第一个缺失的数
        if (nums[0] > 0) {
            // nums[0]的正负表示的是length是否存在
            return length;
        }
        for (int i = 1; i < length; i++) {
            if (nums[i] > 0) {
                return i;
            }
        }

        // 都正确则返回数组长度 + 1
        return length + 1;
    }


    /**
     * 桶排序
     * https://leetcode-cn.com/problems/first-missing-positive/solution/tong-pai-xu-python-dai-ma-by-liweiwei1419/
     */
    public int firstMissingPositiveBinSort(int[] nums) {
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            while (0 < nums[i] && nums[i] <= length && nums[nums[i] - 1] != nums[i]) {
                // 0 < nums[i] <= length: nums[i]的范围在 [1, length], 不在这个范围的不考虑
                // nums[nums[i] - 1] != nums[i]： value落在合适的index上, 例如：数值3应该放在索引2的位置上
                swap(nums, nums[i] - 1, i);
            }
        }

        // 找到不正确的第一个位置并返回
        for (int i = 0; i < length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        // 都正确则返回数组长度 + 1
        return length + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {7, 8, 9, 11, 12};
        int res = new FirstMissingPositive().firstMissingPositive(nums);
        System.out.println(res);
    }
}
