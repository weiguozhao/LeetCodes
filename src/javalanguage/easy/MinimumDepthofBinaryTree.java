package javalanguage.easy;

import javafx.util.Pair;
import javalanguage.utils.TreeNode;

import java.util.Stack;

/**
 * @author zhaoweiguo
 * @date 2019-09-22
 */
public class MinimumDepthofBinaryTree {
    /**
     * problem 111
     * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
     *
     * 给定一个二叉树，找出其最小深度。
     *
     * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
     *
     * 说明: 叶子节点是指没有子节点的节点。
     *
     * 示例:
     *
     * 给定二叉树 [3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *
     * 返回它的最小深度  2.
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        /*
         * 三种情况：
         * 1. 当前是叶节点: 返回 1
         * 2. 当前是单支节点: 返回该支深度
         * 3. 当前是双支节点: 返回较浅的深度
         * */
        if (root.left == null && root.right == null) {
            return 1;
        } else if (root.left == null) {
            return minDepth(root.right) + 1;
        } else if (root.right == null) {
            return minDepth(root.left) + 1;
        }

        int leftDepth = minDepth(root.left) + 1;
        int rightDepth = minDepth(root.right) + 1;
        return leftDepth > rightDepth ? rightDepth : leftDepth;
    }

    public int minDepthIterate(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int minDepth = Integer.MAX_VALUE, currentDepth;
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair<>(root, 1));

        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> current = stack.pop();
            root = current.getKey();
            currentDepth = current.getValue();
            // 叶节点
            if (root.left == null && root.right == null) {
                minDepth = minDepth > currentDepth ? currentDepth : minDepth;
            }

            if (root.left != null) {
                stack.push(new Pair<>(root.left, currentDepth + 1));
            }
            if (root.right != null) {
                stack.push(new Pair<>(root.right, currentDepth + 1));
            }
        }
        return minDepth;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.left.left = new TreeNode(4);

        int res = new MinimumDepthofBinaryTree().minDepthIterate(root);
        System.out.println(res);
    }
}
