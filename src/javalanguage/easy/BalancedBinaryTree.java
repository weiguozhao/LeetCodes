package javalanguage.easy;

import javalanguage.utils.TreeNode;

/**
 * @author zhaoweiguo
 * @date 2019-09-22
 */
public class BalancedBinaryTree {
    /**
     * problem 110
     * https://leetcode-cn.com/problems/balanced-binary-tree/
     */
    public boolean isBalanced(TreeNode root) {
        return binaryTreeDepth(root) != -1;
    }

    private int binaryTreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = binaryTreeDepth(root.left);
        if (leftDepth == -1) {
            return -1;
        }

        int rightDepth = binaryTreeDepth(root.right);
        if (rightDepth == -1) {
            return -1;
        }

        if (Math.abs(leftDepth - rightDepth) > 1) {
            return -1;
        }

        return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
    }

    /**
     * 思考：
     * 重点是找到一个标记表示当前判断的是不是平衡二叉树
     */

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode leftNode = new TreeNode(2);
        root.left = leftNode;
        root.right = new TreeNode(2);
        TreeNode leftLeftNode = new TreeNode(3);
        leftNode.left = leftLeftNode;
        leftNode.right = new TreeNode(3);
        leftLeftNode.left = new TreeNode(4);
        leftLeftNode.right = new TreeNode(4);

        boolean res = new BalancedBinaryTree().isBalanced(root);
        System.out.println(res);
    }
}

/**
 * 更简洁的版本
 */
/*
public class BalancedBinaryTree {
    boolean res = true;

    public boolean isBalanced(TreeNode root) {
        helper(root);
        return res;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left) + 1;
        int right = helper(root.right) + 1;

        if (Math.abs(right - left) > 1) {
            res = false;
        }
        return Math.max(left, right);
    }
}
*/
