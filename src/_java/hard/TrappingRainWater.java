package _java.hard;

import sun.jvm.hotspot.memory.PlaceholderEntry;

/**
 * @author zhaoweiguo
 * @date 2020-01-04
 */
public class TrappingRainWater {
    /**
     * problem 42
     * https://leetcode-cn.com/problems/trapping-rain-water/
     * <p>
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
     * <p>
     * 示例:
     * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
     * 输出: 6
     */

    /**
     * 暴力法(空间换时间版)
     * https://leetcode-cn.com/problems/trapping-rain-water/solution/bao-li-jie-fa-yi-kong-jian-huan-shi-jian-zhi-zhen-/
     * time: O(n)
     * space: O(n)
     * */
    public int trap(int[] height) {
        int length = height.length;
        // left[i]表示i左边的最大值，right[i]表示i右边的最大值
        int[] left = new int[length], right = new int[length];
        for (int i = 1; i < length; i++) {
            left[i] = Math.max(left[i - 1], height[i - 1]);
        }
        for (int i = length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i + 1]);
        }

        int water = 0;
        // 每个格子会保存的水量
        for (int i = 0; i < length; i++) {
            int level = Math.min(left[i], right[i]);
            water += Math.max(0, level - height[i]);
        }
        return water;
    }

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int res = new TrappingRainWater().trap(height);
        System.out.println(res);
    }
}
