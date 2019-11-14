package javalanguage.medium;

/**
 * @author zhaoweiguo
 * @date 2019-10-14
 */
public class ContainerWithMostWater {
    /**
     * problem 11
     * https://leetcode-cn.com/problems/container-with-most-water/
     *
     * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
     * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
     * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     *
     * 说明：你不能倾斜容器，且 n 的值至少为 2。
     *
     * [https://aliyun-lc-upload.oss-cn-hangzhou.aliyuncs.com/aliyun-lc-upload/uploads/2018/07/25/question_11.jpg]
     * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。
     * 在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
     *
     * 示例:
     * 输入: [1,8,6,2,5,4,8,3,7]
     * 输出: 49
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
