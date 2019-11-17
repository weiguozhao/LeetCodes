package javalanguage.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaoweiguo
 * @date 2019-11-17
 */
public class SpiralMatrix {
    /**
     * problem 54
     * https://leetcode-cn.com/problems/spiral-matrix/
     * <p>
     * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
     * <p>
     * 示例 1:
     * 输入:
     * [
     * [ 1, 2, 3 ],
     * [ 4, 5, 6 ],
     * [ 7, 8, 9 ]
     * ]
     * 输出: [1,2,3,6,9,8,7,4,5]
     * <p>
     * 示例 2:
     * 输入:
     * [
     * [1, 2, 3, 4],
     * [5, 6, 7, 8],
     * [9,10,11,12]
     * ]
     * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix.length == 0) {
            return ans;
        }
        int row = matrix.length, col = matrix[0].length;
        boolean[][] seen = new boolean[row][col];
        // Direction: right, down, left, up
        int[] directRow = {0, 1, 0, -1};
        int[] directCol = {1, 0, -1, 0};
        int rowIndex = 0, colIndex = 0, direct = 0;
        for (int i = 0; i < row * col; i++) {
            ans.add(matrix[rowIndex][colIndex]);
            seen[rowIndex][colIndex] = true;
            int cr = rowIndex + directRow[direct];
            int cc = colIndex + directCol[direct];
            if (0 <= cr && cr < row && 0 <= cc && cc < col && !seen[cr][cc]) {
                rowIndex = cr;
                colIndex = cc;
            } else {
                direct = (direct + 1) % 4;
                rowIndex += directRow[direct];
                colIndex += directCol[direct];
            }
        }
        return ans;
    }

    /**
     * 使用最符合逻辑的方式
     * 1. 越界跳出
     * 2. 只剩一个数字的情况;
     * 3. 只剩一行/一列的情况;
     * 4. 正常情况，顺时针旋转遍历;
     * */
    private List<Integer> res;

    public List<Integer> spiralOrder_Direct(int[][] matrix) {
        res = new ArrayList<>();
        if (matrix.length == 0){
            return res;
        }
        spiralOrder_Direct(matrix, 0, matrix.length - 1, 0, matrix[0].length - 1);
        return res;
    }

    private void spiralOrder_Direct(int[][] matrix, int startx, int endx, int starty, int endy) {
        if (startx > endx || starty > endy) {
            return;
        }
        // only number
        if (startx == endx && starty == endy) {
            res.add(matrix[startx][starty]);
            return;
        }
        // only one row
        if (startx == endx && starty != endy) {
            for (int i = starty; i <= endy; i++) {
                res.add(matrix[startx][i]);
            }
            return;
        }
        if (startx != endx && starty == endy) {
            for (int i = startx; i <= endx; i++) {
                res.add(matrix[i][starty]);
            }
            return;
        }
        // up
        for (int i = starty; i < endy; i++) {
            res.add(matrix[startx][i]);
        }
        // right
        for (int i = startx; i < endx; i++) {
            res.add(matrix[i][endy]);
        }
        // bottom
        for (int i = endy; i > starty; i--) {
            res.add(matrix[endx][i]);
        }
        // left
        for (int i = endx; i > startx; i--) {
            res.add(matrix[i][starty]);
        }
        spiralOrder_Direct(matrix, startx + 1, endx - 1, starty + 1, endy - 1);
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}};
        List<Integer> res = new SpiralMatrix().spiralOrder_Direct(matrix);
        for (Integer x : res) {
            System.out.print(x + " ");
        }
    }
}
