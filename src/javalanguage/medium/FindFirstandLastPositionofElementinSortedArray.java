package javalanguage.medium;

/**
 * @author zhaoweiguo
 * @date 2019-10-25
 */
public class FindFirstandLastPositionofElementinSortedArray {
    /**
     * problem 34
     * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
     */
    private int start, end;

    public int[] searchRange(int[] nums, int target) {
        if (nums.length < 1) {
            return new int[]{-1, -1};
        }
        if (nums.length == 1) {
            if (target == nums[0]) {
                return new int[]{0, 0};
            } else {
                return new int[]{-1, -1};
            }
        }
        start = Integer.MAX_VALUE;
        end = -1;
        searchRange(nums, target, 0, nums.length - 1);
        start = start != Integer.MAX_VALUE ? start : -1;
        return new int[]{start, end};
    }

    private void searchRange(int[] nums, int target, int left, int right) {
        if (left > right) {
            return;
        }
        if (left == right) {
            if (target == nums[left]){
                start = start > left ? left : start;
                end = end > left ? end : left;
            }
            return;
        }

        int mid = (left + right) >>> 1;

        if (target == nums[mid]) {
            start = start > mid ? mid : start;
            end = end > mid ? end : mid;
            searchRange(nums, target, left, mid);
            searchRange(nums, target, mid + 1, right);
        } else if (target < nums[mid]) {
            searchRange(nums, target, left, mid);
        } else {
            searchRange(nums, target, mid + 1, right);
        }
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] res = new FindFirstandLastPositionofElementinSortedArray().searchRange(nums, target);
        for (int x : res) {
            System.out.println(x);
        }
    }
}
