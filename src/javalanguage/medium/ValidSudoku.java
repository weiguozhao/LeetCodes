package javalanguage.medium;

import java.util.HashMap;

/**
 * @author zhaoweiguo
 * @date 2019-10-25
 */
public class ValidSudoku {
    /**
     * problem 36
     * https://leetcode-cn.com/problems/valid-sudoku/
     */
    public boolean isValidSudoku(char[][] board) {
        // init data
        HashMap<Integer, Integer>[] rows = new HashMap[9];
        HashMap<Integer, Integer>[] columns = new HashMap[9];
        HashMap<Integer, Integer>[] boxes = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<Integer, Integer>();
            columns[i] = new HashMap<Integer, Integer>();
            boxes[i] = new HashMap<Integer, Integer>();
        }

        // validate a board, i = rowIndex行, j = colIndex列
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num == '.') {
                    continue;
                }

                int n = (int) num;
                int boxIndex = (i / 3) * 3 + j / 3;

                // keep the current cell value
                rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
                columns[j].put(n, columns[j].getOrDefault(n, 0) + 1);
                boxes[boxIndex].put(n, boxes[boxIndex].getOrDefault(n, 0) + 1);

                // check if this value has been already seen before
                if (rows[i].get(n) > 1 || columns[j].get(n) > 1 || boxes[boxIndex].get(n) > 1) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

    }
}
