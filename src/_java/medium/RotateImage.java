package _java.medium;

/**
 * @author zhaoweiguo
 * @date 2019-11-14
 */
public class RotateImage {
    /**
     * problem 48
     * https://leetcode-cn.com/problems/rotate-image/
     *
     * 给定一个 n × n 的二维矩阵表示一个图像。
     * 将图像顺时针旋转 90 度。
     *
     * 说明：
     * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
     *
     * 示例 1:
     * 给定 matrix =
     * [
     *   [1,2,3],
     *   [4,5,6],
     *   [7,8,9]
     * ],
     *
     * 原地旋转输入矩阵，使其变为:
     * [
     *   [7,4,1],
     *   [8,5,2],
     *   [9,6,3]
     * ]
     *
     * 示例 2:
     * 给定 matrix =
     * [
     *   [ 5, 1, 9,11],
     *   [ 2, 4, 8,10],
     *   [13, 3, 6, 7],
     *   [15,14,12,16]
     * ],
     *
     * 原地旋转输入矩阵，使其变为:
     * [
     *   [15,13, 2, 5],
     *   [14, 3, 4, 1],
     *   [12, 6, 8, 9],
     *   [16, 7,10,11]
     * ]
     */
    public void rotate(int[][] matrix) {
//        rotateMatrixTransform(matrix);
        rotateMatrixReplace(matrix);
    }


    private void rotateMatrixReplace(int[][] matrix) {
        int length = matrix.length;
        // 想象从左上角向右下钻
        for (int i = 0; i < (length + 1) / 2; i++) {
            for (int j = 0; j < length / 2; j++) {
                int temp = matrix[length - 1 - j][i];
                matrix[length - 1 - j][i] = matrix[length - 1 - i][length - j - 1];
                matrix[length - 1 - i][length - j - 1] = matrix[j][length - 1 - i];
                matrix[j][length - 1 - i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }

    /**
     * 现将矩阵砖芝，然后每一行reverse
     */
    private void rotateMatrixTransform(int[][] matrix) {
        // transform
        int length = matrix.length;
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                int t1 = matrix[i][j];

                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t1;
            }
        }

        // reverse each row
        for (int i = 0; i < length; i++) {
            // NOTE: 注意这里要除2，要不然相当于做了无用功
            for (int j = 0; j < length / 2; j++) {
                int t1 = matrix[i][j];

                matrix[i][j] = matrix[i][length - 1 - j];
                matrix[i][length - 1 - j] = t1;
            }
        }
    }


    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        new RotateImage().rotate(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
