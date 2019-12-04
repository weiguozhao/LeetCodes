package _java.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaoweiguo
 * @date 2019-09-22
 */
public class PascalsTriangle {
    /**
     * problem 118
     * https://leetcode-cn.com/problems/pascals-triangle/
     *
     * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
     * 在杨辉三角中，每个数是它左上方和右上方的数的和。
     *
     * 示例:
     * 输入: 5
     * 输出:
     * [
     *      [1],
     *     [1,1],
     *    [1,2,1],
     *   [1,3,3,1],
     *  [1,4,6,4,1]
     * ]
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) {
            return result;
        }

        result.add(new ArrayList<>());
        result.get(0).add(1);
        if (numRows == 1) {
            return result;
        }

        for (int i = 1; i < numRows; i++) {
            List<Integer> lastArray = result.get(i - 1);
            List<Integer> currentResult = new ArrayList<>();
            currentResult.add(1);
            for (int j = 1; j < lastArray.size(); j++) {
                currentResult.add(lastArray.get(j) + lastArray.get(j - 1));
            }
            currentResult.add(1);
            result.add(currentResult);
        }

        return result;
    }

    public static void main(String[] args) {
        int numRows = 5;
        List<List<Integer>> res = new PascalsTriangle().generate(numRows);
        for(List<Integer> last: res){
            for(Integer x: last){
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
