package _java.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhaoweiguo
 * @date 2019-11-30
 */
public class SetMatrixZeroes {
    /**
     * problem 73
     * https://leetcode-cn.com/problems/set-matrix-zeroes/
     * <p>
     * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
     * <p>
     * 示例 1:
     * 输入:
     * [
     *   [1,1,1],
     *   [1,0,1],
     *   [1,1,1]
     * ]
     * 输出:
     * [
     *   [1,0,1],
     *   [0,0,0],
     *   [1,0,1]
     * ]
     * <p>
     * 示例 2:
     * 输入:
     * [
     *   [0,1,2,0],
     *   [3,4,5,2],
     *   [1,3,1,5]
     * ]
     * 输出:
     * [
     *   [0,0,0,0],
     *   [0,4,5,0],
     *   [0,3,1,0]
     * ]
     * <p>
     * 进阶:
     * 一个直接的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
     * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
     * 你能想出一个常数空间的解决方案吗？
     * <p>
     * 常数方案：
     * 用每行/每列的第一个数表示该行/列是否需要置0
     * 时间：O(MN)
     * 空间：O(1)
     */

    /**
     * 时间：O(MN)
     * 空间：O(M+N)
     */
    public void setZeroes(int[][] matrix) {
        if (matrix.length < 1 || matrix[0].length < 1) {
            return;
        }

        Set<Integer> rowsSet = new HashSet<>();
        Set<Integer> colsSet = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    rowsSet.add(i);
                    colsSet.add(j);
                }
            }
        }

        for (Integer index : rowsSet) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[index][i] = 0;
            }
        }
        for (Integer index : colsSet) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][index] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };

        new SetMatrixZeroes().setZeroes(matrix);

        for (int[] line : matrix) {
            for (int x : line) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
