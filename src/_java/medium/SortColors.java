package _java.medium;

/**
 * @author zhaoweiguo
 * @date 2019-12-04
 */
public class SortColors {
    /**
     * problem 75
     * https://leetcode-cn.com/problems/sort-colors/
     * <p>
     * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
     * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
     * 注意:
     * 不能使用代码库中的排序函数来解决这道题。
     * <p>
     * 示例:
     * 输入: [2,0,2,1,1,0]
     * 输出: [0,0,1,1,2,2]
     * <p>
     * 进阶：
     * 一个直观的解决方案是使用**计数排序**的两趟扫描算法。
     * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
     * 你能想出一个仅使用常数空间的一趟扫描算法吗？
     * <p>
     * qsort: O(nlogn)
     */
    public void sortColors(int[] nums) {
        int front = 0, last = nums.length - 1, current = 0;
        // 等于 2 的左边界的时候也要判断
        while (current <= last) {
            if (nums[current] == 0) {
                swap(nums, front, current);
                front++;
                current++;
            } else if (nums[current] == 2) {
                // 因为从后面交换过来的值不确定是多少，需要继续判断，所以current不需要+1
                swap(nums, current, last);
                last--;
            } else {
                current++;
            }
        }
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2};
        new SortColors().sortColors(nums);
        for (int x : nums) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
