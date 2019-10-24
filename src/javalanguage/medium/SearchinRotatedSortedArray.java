package javalanguage.medium;

/**
 * @author zhaoweiguo
 * @date 2019-10-23
 */
public class SearchinRotatedSortedArray {
    /**
     * problem 33
     * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
     */
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid;
        while (left < right) {
            mid = (left + right) >>> 1;
            if ((nums[0] > target) ^ (nums[0] > nums[mid]) ^ (target > nums[mid])) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left == right && nums[left] == target ? left : -1;
    }

    public static void main(String[] args) {
        int[] nums = {};
        int target = 10;
        int res = new SearchinRotatedSortedArray().search(nums, target);
        System.out.println(res);
    }
}
