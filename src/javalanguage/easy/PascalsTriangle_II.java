package javalanguage.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaoweiguo
 * @date 2019-09-23
 */
public class PascalsTriangle_II {
    /**
     * problem 119
     * https://leetcode-cn.com/problems/pascals-triangle-ii/
     *
     * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
     * 在杨辉三角中，每个数是它左上方和右上方的数的和。
     *
     * 示例:
     * 输入: 3
     * 输出: [1,3,3,1]
     *
     * 进阶：
     * 你可以优化你的算法到 O(k) 空间复杂度吗？
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        result.add(1);
        if (rowIndex == 0) {
            return result;
        }

        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> tempList = new ArrayList<>();
            tempList.add(1);
            for (int j = 1; j < result.size(); j++) {
                tempList.add(result.get(j - 1) + result.get(j));
            }
            tempList.add(1);
            result = tempList;
        }

        return result;
    }


    public static void main(String[] args) {
        int rowIndex = 3;
        List<Integer> res = new PascalsTriangle_II().getRow(rowIndex);
        for(Integer x: res){
            System.out.print(x + " ");
        }
    }
}
