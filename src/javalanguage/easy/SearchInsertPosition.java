package javalanguage.easy;

/**
 * @author zhaoweiguo
 * @date 2019-09-15
 */
public class SearchInsertPosition {
    /**
     * problem 35
     * https://leetcode-cn.com/problems/search-insert-position/
     *
     * 二分法详细讲解：
     * https://leetcode-cn.com/problems/search-insert-position/solution/te-bie-hao-yong-de-er-fen-cha-fa-fa-mo-ban-python-/
     */
    public int searchInsert(int[] nums, int target) {
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }

//        return halfSearch(nums, 0, nums.length - 1, target);
        return binarySearch(nums, target);
    }

    /**
     * 非递归二分查找
     */
    private int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            // 在left和right比较大的时候容易越界
            // int mid = (left + right) / 2;
            // 常规操作：right很小，left很大的情况下也会溢出
            // int mid = left + (right - left) / 2;
            // 更好的操作
            int mid = (left + right) >>> 1;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    /**
     * 递归二分查找
     */
    private int halfSearch(int[] nums, int left, int right, int target) {
        // 只能是这种情况 halfSearch(nums, left, mid - 1, target);
        if (left > right) {
            return left;
        }

        if (left == right) {
            if (nums[left] == target) {
                return left;
            } else if (nums[left] < target) {
                return right + 1;
            } else {
                return left;
            }
        }

        int mid = (left + right) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return halfSearch(nums, mid + 1, right, target);
        } else {
            return halfSearch(nums, left, mid - 1, target);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 4;

        int res = new SearchInsertPosition().searchInsert(nums, target);
        System.out.println(res);
    }
}
