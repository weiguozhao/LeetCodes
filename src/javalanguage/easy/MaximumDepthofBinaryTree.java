package javalanguage.easy;

import javafx.util.Pair;
import javalanguage.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author zhaoweiguo
 * @date 2019-09-22
 */
public class MaximumDepthofBinaryTree {
    /**
     * problem 104
     * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
     */

    /**
     * 递归版dfs
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(1 + maxDepth(root.left), 1 + maxDepth(root.right));
    }

    /**
     * 建立自定义 Pair<TreeNode, Integer> 格式，记录每个节点所在的层数
     * bfs
     */
    public int maxDepthBfs(TreeNode root) {
        int hight = 0;
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();

        if (root != null) {
            queue.add(new Pair<>(root, 1));
        }
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> current = queue.poll();
            root = current.getKey();
            int currentHight = current.getValue();

            if (root != null) {
                hight = hight > currentHight ? hight : currentHight;
                queue.add(new Pair<>(root.left, currentHight + 1));
                queue.add(new Pair<>(root.right, currentHight + 1));
            }
        }
        return hight;
    }

    /**
     * dfs
     */
    public int maxDepthDfs(TreeNode root) {
        int hight = 0;
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();

        if (root != null) {
            stack.push(new Pair<>(root, 1));
        }

        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> current = stack.peek();
            stack.pop();
            TreeNode currentNode = current.getKey();
            Integer currentHight = current.getValue();
            hight = hight > currentHight ? hight : currentHight;

            if (currentNode.left != null) {
                stack.push(new Pair<>(currentNode.left, currentHight + 1));
            }
            if (currentNode.right != null) {
                stack.push(new Pair<>(currentNode.right, currentHight + 1));
            }
        }

        return hight;
    }


    public static void main(String[] args) {
        MaximumDepthofBinaryTree obj = new MaximumDepthofBinaryTree();

        TreeNode root = new TreeNode(3);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int hight = 0;
        obj.maxDepthDfs(root);
        System.out.println(hight);
    }
}
