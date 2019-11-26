package javalanguage.medium;

/**
 * @author zhaoweiguo
 * @date 2019-11-26
 */
public class SpiralMatrix_II {
    /**
     * problem 59
     * https://leetcode-cn.com/problems/spiral-matrix-ii/
     *
     * 给定一个正整数 n，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
     *
     * 示例:
     * 输入: 3
     * 输出:
     * [
     *  [ 1, 2, 3 ],
     *  [ 8, 9, 4 ],
     *  [ 7, 6, 5 ]
     * ]
     * */
    public int[][] generateMatrix(int n) {
        int[] directRow = {0, 1, 0, -1};
        int[] directCol = {1, 0, -1, 0};

        int[][] matrix = new int[n][n];
        int dirextIndex = 0, rowIndex = 0, colIndex = 0, value = 1;

        for (int i = 0; i < n * n; i++) {
            matrix[rowIndex][colIndex] = value;
            value++;
            int cr = rowIndex + directRow[dirextIndex];
            int cc = colIndex + directCol[dirextIndex];
            /*
            * 判断是否越界
            * */
            if (0 <= cr && cr < n && 0 <= cc && cc < n && matrix[cr][cc] == 0) {
                rowIndex = cr;
                colIndex = cc;
            } else {
                /*
                 * 越界的话进行换向
                 */
                dirextIndex = (dirextIndex + 1) % 4;
                rowIndex += directRow[dirextIndex];
                colIndex += directCol[dirextIndex];
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
        int[][] res = new SpiralMatrix_II().generateMatrix(3);
        for(int[] items: res) {
            for(int x: items) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
