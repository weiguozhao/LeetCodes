package javalanguage.easy;

import javalanguage.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhaoweiguo
 * @date 2019-09-20
 */
public class SymmetricTree {
    /**
     * problem 101
     * https://leetcode-cn.com/problems/symmetric-tree/
     *
     * 给定一个二叉树，检查它是否是镜像对称的。
     *
     * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
     *     1
     *    / \
     *   2   2
     *  / \ / \
     * 3  4 4  3
     *
     * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
     *     1
     *    / \
     *   2   2
     *    \   \
     *    3    3
     *
     * 说明:
     * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
     */
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root, root);
    }

    private boolean isSymmetric(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val == q.val) {
            return isSymmetric(p.left, q.right) && isSymmetric(p.right, q.left);
        }
        return false;
    }


    /**
     *
     * */
    public boolean isSymmetricIterate(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();

            if (t1 == null && t2 == null){
                continue;
            }
            if (t1 == null || t2 == null){
                return false;
            }

            if (t1.val != t2.val){
                return false;
            }
            // 注意下面加入队列的顺序
            queue.add(t1.left);
            queue.add(t2.right);
            queue.add(t1.right);
            queue.add(t2.left);
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode leftNode = new TreeNode(2);
        TreeNode rightNode = new TreeNode(3);

        treeNode.left = leftNode;
        treeNode.right = rightNode;

        boolean res = new SymmetricTree().isSymmetric(treeNode);
        System.out.println(res);
    }
}
