package _java.easy;

import javafx.util.Pair;
import _java.utils.TreeNode;

import java.util.Stack;

/**
 * @author zhaoweiguo
 * @date 2019-09-22
 */
public class PathSum {
    /**
     * problem 112
     * https://leetcode-cn.com/problems/path-sum/
     *
     * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
     * 说明: 叶子节点是指没有子节点的节点。
     *
     * 示例: 
     * 给定如下二叉树，以及目标和 sum = 22，
     *
     *               5
     *              / \
     *             4   8
     *            /   / \
     *           11  13  4
     *          /  \      \
     *         7    2      1
     * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return hasPathSumRecursion(root, sum);
    }

    private boolean hasPathSumRecursion(TreeNode root, int sum) {
        if (root.left == null && root.right == null) {
            return sum - root.val == 0;
        } else if (root.left == null) {
            return hasPathSumRecursion(root.right, sum - root.val);
        } else if (root.right == null) {
            return hasPathSumRecursion(root.left, sum - root.val);
        } else {
            boolean leftRes = hasPathSumRecursion(root.left, sum - root.val);
            boolean rightRes = hasPathSumRecursion(root.right, sum - root.val);
            return leftRes || rightRes;
        }
    }

    public boolean hasPathSumIterate(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        int value;
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair<>(root, sum - root.val));

        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> current = stack.pop();
            root = current.getKey();
            value = current.getValue();

            if (root.left == null && root.right == null && value == 0) {
                return true;
            }

            if (root.left != null) {
                stack.push(new Pair<>(root.left, value - root.left.val));
            }
            if (root.right != null) {
                stack.push(new Pair<>(root.right, value - root.right.val));
            }
        }

        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        boolean res = new PathSum().hasPathSum(root, 2);
        System.out.println(res);
    }
}
