package javalanguage.medium;

/**
 * @author zhaoweiguo
 * @date 2019-11-29
 */
public class MinimumPathSum {
    /**
     * problem 64
     * https://leetcode-cn.com/problems/minimum-path-sum/
     * <p>
     * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
     * 说明：每次只能向下或者向右移动一步。
     * <p>
     * 示例:
     * 输入:
     * [
     *   [1,3,1],
     *   [1,5,1],
     *   [4,2,1]
     * ]
     * 输出: 7
     * 解释: 因为路径 1→3→1→1→1 的总和最小。
     */
    public int minPathSum(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;

        int[][] table = new int[rows][cols];
        table[0][0] = grid[0][0];
        // 第一列
        for (int i = 1; i < rows; i++) {
            table[i][0] = grid[i][0] + table[i - 1][0];
        }
        // 第一行
        for (int i = 1; i < cols; i++) {
            table[0][i] = grid[0][i] + table[0][i - 1];
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                int minValue = table[i - 1][j] > table[i][j - 1] ? table[i][j - 1] : table[i - 1][j];
                // current = current + min(up, left)
                table[i][j] = grid[i][j] + minValue;
            }
        }

        return table[rows - 1][cols - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}};
        int res = new MinimumPathSum().minPathSum(grid);
        System.out.println(res);
    }
}
