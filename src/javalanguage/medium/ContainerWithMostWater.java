package javalanguage.medium;

/**
 * @author zhaoweiguo
 * @date 2019-10-14
 */
public class ContainerWithMostWater {
    /**
     * problem 11
     * https://leetcode-cn.com/problems/container-with-most-water/
     */
    /**
     * 暴力
     */
    public int maxArea1(int[] height) {
        int res = 0, length = height.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int area = (j - i) * Math.min(height[i], height[j]);
                res = res > area ? res : area;
            }
        }
        return res;
    }

    /**
     * 双指针法
     */
    public int maxArea(int[] height) {
        int res = 0, length = height.length;

        for (int i = 0, j = length - 1; i < j; ) {
            int thisArea = (j - i) * Math.min(height[i], height[j]);
            res = res > thisArea ? res : thisArea;
            if (height[i] < height[j]){
                i++;
            } else {
                j--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] height = {1, 2, 1};
        int res = new ContainerWithMostWater().maxArea(height);
        System.out.println(res);
    }
}
