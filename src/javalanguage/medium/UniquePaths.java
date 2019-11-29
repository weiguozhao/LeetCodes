package javalanguage.medium;

/**
 * @author zhaoweiguo
 * @date 2019-11-29
 */
public class UniquePaths {
    /**
     * problem 62
     * https://leetcode-cn.com/problems/unique-paths/
     * <p>
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
     * 问总共有多少条不同的路径？
     * <p>
     * 说明：m 和 n 的值均不超过 100。
     * <p>
     * 示例 1:
     * 输入: m = 3, n = 2
     * 输出: 3
     * 解释:
     * 从左上角开始，总共有 3 条路径可以到达右下角。
     * 1. 向右 -> 向右 -> 向下
     * 2. 向右 -> 向下 -> 向右
     * 3. 向下 -> 向右 -> 向右
     * <p>
     * 示例 2:
     * 输入: m = 7, n = 3
     * 输出: 28
     */
    public int uniquePaths(int m, int n) {
        if (m < 1 || n < 1) {
            return 0;
        }

        int[][] table = new int[m][n];
        for (int i = 0; i < m; i++) {
            table[i][n - 1] = 1;
        }
        for (int i = 0; i < n; i++) {
            table[m - 1][i] = 1;
        }
        return uniquePaths(0, 0, table);
    }

    private int uniquePaths(int row, int col, int[][] table) {
        if (table[row][col] != 0) {
            return table[row][col];
        }

        // go down
        int down = 0;
        if (row < table.length - 1) {
            down = uniquePaths(row + 1, col, table);
        }
        // go right
        int right = 0;
        if (col < table[0].length - 1) {
            right = uniquePaths(row, col + 1, table);
        }
        table[row][col] = down + right;
        return table[row][col];
    }

    public static void main(String[] args) {
        int m = 51, n = 9;
        int res = new UniquePaths().uniquePaths(m, n);
        System.out.println(res);
    }
}
