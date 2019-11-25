package javalanguage.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author zhaoweiguo
 * @date 2019-11-25
 */
public class MergeIntervals {
    /**
     * problem 56
     * https://leetcode-cn.com/problems/merge-intervals/
     * <p>
     * 给出一个区间的集合，请合并所有重叠的区间。
     * <p>
     * 示例 1:
     * 输入: [[1,3],[2,6],[8,10],[15,18]]
     * 输出: [[1,6],[8,10],[15,18]]
     * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     * <p>
     * 示例 2:
     * 输入: [[1,4],[4,5]]
     * 输出: [[1,5]]
     * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
     */
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }
        // 实现Comparator接口进行排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });

        int left = intervals[0][0], right = intervals[0][1];
        List<int[]> list = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            // 由于排过序了，则intervals[i][0] 一定不小于left，
            // 所以只需要比较intervals[i][0]和right的大小关系
            if (intervals[i][0] <= right) {
                right = Math.max(right, intervals[i][1]);
            } else {
                // 无重叠部分，先把上一段区间加到list中
                list.add(new int[]{left, right});
                left = intervals[i][0];
                right = intervals[i][1];
            }
        }
        // 注意这里for循环结束后, 要把剩余最后的区间add进来
        list.add(new int[]{left, right});
        int[][] result = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] res = new MergeIntervals().merge(intervals);
        for(int[] item: res) {
            for(int x: item) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
