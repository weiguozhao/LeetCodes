package _java.hard;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaoweiguo
 * @date 2020-01-10
 */
public class NQueens {
    /**
     * problem 51
     * https://leetcode-cn.com/problems/n-queens/
     * <p>
     * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
     * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
     * <p>
     * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
     * <p>
     * 示例:
     * 输入: 4
     * 输出: [
     * [".Q..",  // 解法 1
     * "...Q",
     * "Q...",
     * "..Q."],
     * <p>
     * ["..Q.",  // 解法 2
     * "Q...",
     * "...Q",
     * ".Q.."]
     * ]
     * 解释: 4 皇后问题存在两个不同的解法。
     */
    private int[] rows;
    private int[] hills;
    private int[] dales;
    int n;
    private List<List<String>> output;
    private int[] queensPosition;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        rows = new int[n];
        hills = new int[4 * n - 1];
        dales = new int[2 * n - 1];
        output = new ArrayList<>();
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
        List<String> solution = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            int col = queensPosition[i];
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < col; ++j) {
                sb.append(".");
            }
            sb.append("Q");
            for (int j = 0; j < n - col - 1; ++j) {
                sb.append(".");
            }
            solution.add(sb.toString());
        }
        output.add(solution);
    }


    public static void main(String[] args) {
        int n = 4;
        List<List<String>> res = new NQueens().solveNQueens(n);
        for (List<String> line : res) {
            for (String item : line) {
                System.out.println(item);
            }
            System.out.println();
        }
    }
}
