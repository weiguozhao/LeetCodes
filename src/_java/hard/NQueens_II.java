package _java.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaoweiguo
 * @date 2020-01-11
 */
public class NQueens_II {
    /**
     * problem 52
     * https://leetcode-cn.com/problems/n-queens-ii/
     * <p>
     * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
     * 给定一个整数 n，返回 n 皇后不同的解决方案的数量。
     * <p>
     * 示例:
     * 输入: 4
     * 输出: 2
     * 解释: 4 皇后问题存在如下两个不同的解法。
     * [
     *  [".Q..",  // 解法 1
     *   "...Q",
     *   "Q...",
     *   "..Q."],
     * <p>
     *  ["..Q.",  // 解法 2
     *   "Q...",
     *   "...Q",
     *   ".Q.."]
     * ]
     */
    private int[] rows;
    private int[] hills;
    private int[] dales;
    int n;
    private int output;
    private int[] queensPosition;

    public int totalNQueens(int n) {
        this.n = n;
        rows = new int[n];
        hills = new int[4 * n - 1];
        dales = new int[2 * n - 1];
        output = 0;
        queensPosition = new int[n];

        backtrack(0);

        return output;
    }

    private void backtrack(int row) {
        for (int col = 0; col < n; col++) {
            if (isNotUnderAttack(row, col)) {
                placeQueen(row, col);
                if (row + 1 == n) {
                    // if n queens are already placed
                    addSolution();
                } else {
                    // if not proceed to place the rest
                    backtrack(row + 1);
                }
                // backtrack
                removeQueen(row, col);
            }
        }
    }

    public boolean isNotUnderAttack(int row, int col) {
        int res = rows[col] + hills[row - col + 2 * n] + dales[row + col];
        return res == 0;
    }

    public void placeQueen(int row, int col) {
        queensPosition[row] = col;
        rows[col] = 1;
        // "hill" diagonals
        hills[row - col + 2 * n] = 1;
        //"dale" diagonals
        dales[row + col] = 1;
    }

    public void removeQueen(int row, int col) {
        queensPosition[row] = 0;
        rows[col] = 0;
        hills[row - col + 2 * n] = 0;
        dales[row + col] = 0;
    }

    public void addSolution() {
        output++;
    }

    public static void main(String[] args) {
        int n = 4;
        int res = new NQueens_II().totalNQueens(n);
        System.out.println(res);
    }
}
