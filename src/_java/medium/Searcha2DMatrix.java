package _java.medium;

/**
 * @author zhaoweiguo
 * @date 2019-12-02
 */
public class Searcha2DMatrix {
    /**
     * problem 74
     * https://leetcode-cn.com/problems/search-a-2d-matrix/
     * <p>
     * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
     * 每行中的整数从左到右按升序排列。
     * 每行的第一个整数大于前一行的最后一个整数。
     * <p>
     * 示例 1:
     * 输入:
     * matrix = [
     * [1,   3,  5,  7],
     * [10, 11, 16, 20],
     * [23, 30, 34, 50]
     * ]
     * target = 3
     * 输出: true
     * <p>
     * 示例 2:
     * 输入:
     * matrix = [
     * [1,   3,  5,  7],
     * [10, 11, 16, 20],
     * [23, 30, 34, 50]
     * ]
     * target = 13
     * 输出: false
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }

        int rows = matrix.length, cols = matrix[0].length;
        int low = 0, big = rows - 1, mid;
        while (low < big) {
            // 控制取右中位数
            mid = (low + big + 1) >> 1;
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] < target) {
                low = mid;
            } else {
                big = mid - 1;
            }
        }
        if (matrix[low][0] == target) {
            return true;
        }
        int targetRow = low;

        low = 0;
        big = cols - 1;
        while (low < big) {
            mid = (low + big) >> 1;
            if (matrix[targetRow][mid] == target) {
                return true;
            } else if (matrix[targetRow][mid] < target) {
                low = mid + 1;
            } else {
                big = mid;
            }
        }
        return matrix[targetRow][low] == target;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}};
        int target = 3;
        boolean res = new Searcha2DMatrix().searchMatrix(matrix, target);
        System.out.println(res);
    }
}