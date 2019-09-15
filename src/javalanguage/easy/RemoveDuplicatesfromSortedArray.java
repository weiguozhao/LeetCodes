package javalanguage.easy;

/**
 * @author zhaoweiguo
 * @date 2019-09-15
 */
public class RemoveDuplicatesfromSortedArray {
    /**
     * problem 26.
     * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }

        int point = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[point-1]) {
                nums[point] = nums[i];
                point++;
            }
        }
        return point;
    }


    public static void main(String[] args) {
        int[] nums = {1, 1, 3};

        int res = new RemoveDuplicatesfromSortedArray().removeDuplicates(nums);
        System.out.println(res);
        for (int x : nums) {
            System.out.print(x + " ");
        }
    }
}
