package javalanguage.easy;

import javalanguage.utils.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author zhaoweiguo
 * @date 2019-09-22
 */
public class BinaryTreeLevelOrderTraversal_II {
    /**
     * problem 107
     * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> level = new LinkedList<>();
            Queue<TreeNode> tempQueue = new LinkedList<>();
            while (!queue.isEmpty()) {
                root = queue.poll();
                level.add(root.val);
                tempQueue.add(root);
            }

            result.addFirst(level);
            while (!tempQueue.isEmpty()) {
                root = tempQueue.poll();
                if (root.left != null) {
                    queue.add(root.left);
                }
                if (root.right != null) {
                    queue.add(root.right);
                }
            }
        }
        return result;
    }

    /**
     * 思路：
     * 每次将一层的Node都取出来，之后将下一层的Node全都放到Queue中，一直到Queue为空，即没有下一层数据
     */

    public static void main(String[] args) {
        //         3
        //        / \
        //       9  20
        //         /  \
        //        15   7
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        TreeNode rightNode = new TreeNode(20);
        root.right = rightNode;
        rightNode.left = new TreeNode(15);
        rightNode.right = new TreeNode(7);

        BinaryTreeLevelOrderTraversal_II obj = new BinaryTreeLevelOrderTraversal_II();
        List<List<Integer>> result = obj.levelOrderBottom(root);

        for (List<Integer> level : result) {
            for (Integer x : level) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
