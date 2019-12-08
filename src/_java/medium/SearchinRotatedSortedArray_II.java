package _java.medium;

/**
 * @author zhaoweiguo
 * @date 2019-12-08
 */
public class SearchinRotatedSortedArray_II {
    /**
     * problem 81
     * https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/
     * <p>
     * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
     * ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
     * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
     * <p>
     * 示例 1:
     * 输入: nums = [2,5,6,0,0,1,2], target = 0
     * 输出: true
     * <p>
     * 示例 2:
     * 输入: nums = [2,5,6,0,0,1,2], target = 3
     * 输出: false
     */
    public boolean search(int[] nums, int target) {
        int length = nums.length;
        if (length < 1) {
            return false;
        }

        int left = 0, right = length - 1, mid;
        while (left < right) {
            mid = (left + right) >>> 1;
            // 先判断两部分的有序性
            if (nums[left] < nums[mid]) {
                // 落在有序部分里
                if (nums[left] <= target && target <= nums[mid]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            } else if (nums[left] > nums[mid]) {
                // 让分支和上面分支一样
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            } else {
                // 要排除掉左边界之前，先看一看左边界可以不可以排除
                if (nums[left] == target) {
                    return true;
                } else {
                    left = left + 1;
                }
            }
        }
        return nums[left] == target;
    }

    public static void main(String[] args) {
        int[] nums = {2, 5, 6, 0, 0, 1, 2};
        int target = 3;
        boolean res = new SearchinRotatedSortedArray_II().search(nums, target);
        System.out.println(res);
    }
}
