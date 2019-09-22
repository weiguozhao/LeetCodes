package javalanguage.easy;

import apple.laf.JRSUIUtils;
import javalanguage.utils.TreeNode;

import java.util.Stack;

/**
 * @author zhaoweiguo
 * @date 2019-09-22
 */
public class ConvertSortedArraytoBinarySearchTree {
    /**
     * problem 108
     * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length < 1) {
            return null;
        }
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) >>> 1;
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = sortedArrayToBST(nums, left, mid - 1);
        treeNode.right = sortedArrayToBST(nums, mid + 1, right);
        return treeNode;
    }

    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode root = new ConvertSortedArraytoBinarySearchTree().sortedArrayToBST(nums);
    }
}
