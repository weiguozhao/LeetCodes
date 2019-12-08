package _java.medium;

/**
 * @author zhaoweiguo
 * @date 2019-12-08
 */
public class RemoveDuplicatesfromSortedArray_II {
    /**
     * problem 80
     * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/
     * <p>
     * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     * <p>
     * 示例 1:
     * 给定 nums = [1,1,1,2,2,3],
     * 函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
     * 你不需要考虑数组中超出新长度后面的元素。
     * <p>
     * 示例 2:
     * 给定 nums = [0,0,1,1,1,1,2,3,3],
     * 函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。
     * 你不需要考虑数组中超出新长度后面的元素。
     */
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        if (length <= 2) {
            return length;
        }

        int slow = 1;
        for (int fast = 2; fast < length; fast++) {
            if (nums[fast] != nums[slow - 1]) {
                nums[++slow] = nums[fast];
            }
        }
        return slow + 1;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        int res = new RemoveDuplicatesfromSortedArray_II().removeDuplicates(nums);
        for (int i = 0; i < res; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}
