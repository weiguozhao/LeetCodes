package _java.medium;

/**
 * @author zhaoweiguo
 * @date 2019-12-07
 */
public class WordSearch {
    /**
     * problem 79
     * https://leetcode-cn.com/problems/word-search/
     * <p>
     * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
     * 同一个单元格内的字母不允许被重复使用。
     * <p>
     * 示例:
     * board =
     * [
     * ['A','B','C','E'],
     * ['S','F','C','S'],
     * ['A','D','E','E']
     * ]
     * <p>
     * 给定 word = "ABCCED", 返回 true.
     * 给定 word = "SEE", 返回 true.
     * 给定 word = "ABCB", 返回 false.
     */
    private int rows, cols;
    private char[][] board;
    private boolean[][] seen;
    private String word;
    private int[][] direction = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    /**
     * 二维平面的回溯法：
     * 先要找到入口节点，注意private变量的使用可以将主要精力放在解决问题的思路上，而不是传递参数
     * */
    public boolean exist(char[][] board, String word) {
        if (word.length() < 1) {
            return true;
        }
        if (board == null || board.length < 1 || board[0].length < 1) {
            return false;
        }

        this.rows = board.length;
        this.cols = board[0].length;
        this.board = board;
        this.seen = new boolean[rows][cols];
        this.word = word;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] != word.charAt(0)) {
                    continue;
                }
                if (exist(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 二维平面的回溯法
     * 注意direction偏移量数组的使用既可以简化代码，也可以清晰思路
     */
    private boolean exist(int row, int col, int index) {
        if (index == word.length() - 1) {
            return word.charAt(index) == board[row][col];
        }

        if (board[row][col] == word.charAt(index)) {
            seen[row][col] = true;

            for (int d = 0; d < 4; d++) {
                int newRow = row + direction[d][0];
                int newCol = col + direction[d][1];

                if (inBoard(newRow, newCol) && !seen[newRow][newCol]) {
                    if (exist(newRow, newCol, index + 1)) {
                        return true;
                    }
                }
            }

            seen[row][col] = false;
        }

        return false;
    }

    /**
     * 判断坐标是否在board上
     */
    private boolean inBoard(int row, int col) {
        return row >= 0 && col >= 0 && row < rows && col < cols;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCESEEEFS";
        System.out.print(new WordSearch().exist(board, word));
    }
}
