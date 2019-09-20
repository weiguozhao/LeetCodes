package javalanguage.easy;

import javalanguage.utils.TreeNode;

import java.util.ArrayDeque;

/**
 * @author zhaoweiguo
 * @date 2019-09-20
 */
public class SameTree {
    /**
     * problem 100
     * https://leetcode-cn.com/problems/same-tree/
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p != null && q != null && p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return false;
    }

    /**
     * 思路是用两个队列，类前序遍历二叉树
     */
    public boolean isSameTreeIterate(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (!check(p, q)) {
            return false;
        }

        // init deques
        ArrayDeque<TreeNode> deqP = new ArrayDeque<TreeNode>();
        ArrayDeque<TreeNode> deqQ = new ArrayDeque<TreeNode>();
        deqP.addLast(p);
        deqQ.addLast(q);

        while (!deqP.isEmpty()) {
            // 取出队列第一个元素
            p = deqP.removeFirst();
            q = deqQ.removeFirst();
            // check
            if (!check(p, q)) {
                return false;
            }
            if (p != null) {
                // in Java nulls are not allowed in Deque
                if (!check(p.left, q.left)) {
                    return false;
                }
                if (p.left != null) {
                    deqP.addLast(p.left);
                    deqQ.addLast(q.left);
                }
                if (!check(p.right, q.right)) {
                    return false;
                }
                if (p.right != null) {
                    deqP.addLast(p.right);
                    deqQ.addLast(q.right);
                }
            }
        }
        return true;
    }

    private boolean check(TreeNode p, TreeNode q) {
        // p and q are null
        if (p == null && q == null) {
            return true;
        }
        // one of p and q is null
        if (q == null || p == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode leftNode = new TreeNode(2);
        TreeNode rightNode = new TreeNode(3);

        treeNode.left = leftNode;
        treeNode.right = rightNode;

        boolean res = new SameTree().isSameTree(treeNode, treeNode);
        System.out.println(res);
    }
}
