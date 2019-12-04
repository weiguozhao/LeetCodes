package _java.easy;

/**
 * @author zhaoweiguo
 * @date 2019-09-26
 */
public class ExcelSheetColumnNumber {
    /**
     * problem 171
     * https://leetcode-cn.com/problems/excel-sheet-column-number/
     *
     * 给定一个Excel表格中的列名称，返回其相应的列序号。
     *
     * 例如，
     *     A -> 1
     *     B -> 2
     *     C -> 3
     *     ...
     *     Z -> 26
     *     AA -> 27
     *     AB -> 28
     *     ...
     *
     * 示例 1:
     * 输入: "A"
     * 输出: 1
     *
     * 示例 2:
     * 输入: "AB"
     * 输出: 28
     *
     * 示例 3:
     * 输入: "ZY"
     * 输出: 701
     */
    public int titleToNumber(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res = res * 26 + s.charAt(i) - 'A' + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "AA";
        int res = new ExcelSheetColumnNumber().titleToNumber(s);
        System.out.println(res);
    }
}
