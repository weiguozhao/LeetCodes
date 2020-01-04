package _java.hard;

/**
 * @author zhaoweiguo
 * @date 2020-01-02
 */
public class SudokuSolver {
    /**
     * problem 37
     * https://leetcode-cn.com/problems/sudoku-solver/
     * <p>
     * 编写一个程序，通过已填充的空格来解决数独问题。
     * <p>
     * 一个数独的解法需遵循如下规则：
     * 数字 1-9 在每一行只能出现一次。
     * 数字 1-9 在每一列只能出现一次。
     * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
     * 空白格用 '.' 表示。
     * <p>
     * Note:
     * 给定的数独序列只包含数字 1-9 和字符 '.' 。
     * 你可以假设给定的数独只有唯一解。
     * 给定数独永远是 9x9 形式的。
     */

    private boolean[][] rows = new boolean[9][10];
    private boolean[][] columns = new boolean[9][10];
    private boolean[][] boxes = new boolean[9][10];

    public void solveSudoku(char[][] board) {
        // 根据board上的信息，初始化set
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }

                int num = board[i][j] - '0';
                int boxIndex = (i / 3) * 3 + j / 3;
                rows[i][num] = true;
                columns[j][num] = true;
                boxes[boxIndex][num] = true;
            }
        }

        // 递归找解决方案
        solveSudokuRecurrent(board, 0, 0);
    }

    private boolean solveSudokuRecurrent(char[][] board, int i, int j) {
        if (j >= 9) {
            // 换下一行
            j = 0;
            i += 1;
            if (i >= 9) {
                return true;
            }
        }

        // 当前位置填充过
        if (board[i][j] != '.') {
            return solveSudokuRecurrent(board, i, j + 1);
        }

        // 填充的值范围是 [1, 9]
        for (int n = 1; n <= 9; n++) {
            if (!isValidNum(n, i, j)) {
                continue;
            }

            board[i][j] = (char) ('0' + n);
            int boxIndex = (i / 3) * 3 + j / 3;
            rows[i][n] = true;
            columns[j][n] = true;
            boxes[boxIndex][n] = true;

            if (solveSudokuRecurrent(board, i, j + 1)) {
                return true;
            }

            rows[i][n] = false;
            columns[j][n] = false;
            boxes[boxIndex][n] = false;
            board[i][j] = '.';
        }

        return false;
    }

    private boolean isValidNum(int num, int rowIndex, int colIndex) {
        boolean valid = true;
        int boxIndex = (rowIndex / 3) * 3 + colIndex / 3;
        if (rows[rowIndex][num] || columns[colIndex][num] || boxes[boxIndex][num]) {
            valid = false;
        }
        return valid;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'},
        };
        new SudokuSolver().solveSudoku(board);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

        // Answer
//        5 3 4 6 7 8 9 1 2
//        6 7 2 1 9 5 3 4 8
//        1 9 8 3 4 2 5 6 7
//        8 5 9 7 6 1 4 2 3
//        4 2 6 8 5 3 7 9 1
//        7 1 3 9 2 4 8 5 6
//        9 6 1 5 3 7 2 8 4
//        2 8 7 4 1 9 6 3 5
//        3 4 5 2 8 6 1 7 9
    }
}
