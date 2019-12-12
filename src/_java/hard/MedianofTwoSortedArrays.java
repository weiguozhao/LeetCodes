package _java.hard;

/**
 * @author zhaoweiguo
 * @date 2019-12-11
 */
public class MedianofTwoSortedArrays {
    /**
     * problem 4
     * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
     * <p>
     * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
     * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
     * 你可以假设 nums1 和 nums2 不会同时为空。
     * <p>
     * 示例 1:
     * nums1 = [1, 3]
     * nums2 = [2]
     * 则中位数是 2.0
     * <p>
     * 示例 2:
     * nums1 = [1, 2]
     * nums2 = [3, 4]
     * 则中位数是 (2 + 3)/2 = 2.5
     */

    /**
     * 有序数组，提前确定中位数的index
     * 之后变成寻找这个index的问题，需要注意的是区分左中位数、右中位数
     * 当总个数为偶数时：返回左中位数、右中位数的平均值
     * 当总个数为奇数时：返回右中位数
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int medianIndex = (m + n) >>> 1;

        int index1 = 0, index2 = 0;
        int leftMedianValue = 0, rightMedianValue = 0;

        // Trick: 这里使用medianIndex来控制循环，而不是m、n
        for (int i = 0; i <= medianIndex; i++) {
            // 每次将较小的那个值保存
            leftMedianValue = rightMedianValue;
            if (index2 >= n || (index1 < m && nums1[index1] < nums2[index2])) {
                rightMedianValue = nums1[index1++];
            } else {
                rightMedianValue = nums2[index2++];
            }
        }

        if ((m + n) % 2 == 0) {
            // 当总个数为偶数时，中位数为左中位数和右中位数的平均
            return (leftMedianValue + rightMedianValue) / 2.0;
        } else {
            // 当总个数为奇数个时，返回右中位数
            return rightMedianValue;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 4};
        int[] nums2 = {2};

        double res = new MedianofTwoSortedArrays().findMedianSortedArrays(nums1, nums2);
        System.out.println(res);
    }
}
