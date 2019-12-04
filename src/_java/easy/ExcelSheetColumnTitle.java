package _java.easy;

/**
 * @author zhaoweiguo
 * @date 2019-09-25
 */
public class ExcelSheetColumnTitle {
    /**
     * problem 168
     * https://leetcode-cn.com/problems/excel-sheet-column-title/
     *
     * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
     *
     * 例如，
     *     1 -> A
     *     2 -> B
     *     3 -> C
     *     ...
     *     26 -> Z
     *     27 -> AA
     *     28 -> AB
     *     ...
     *
     * 示例 1:
     * 输入: 1
     * 输出: "A"
     *
     * 示例 2:
     * 输入: 28
     * 输出: "AB"
     *
     * 示例 3:
     * 输入: 701
     * 输出: "ZY"
     */
    public String convertToTitle(int n) {
        if (n <= 0) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        while (n > 0) {
            n--;
            res.append((char) (n % 26 + 'A'));
            n = n / 26;
        }
        return res.reverse().toString();
    }

    /**
     * 思路：
     * 26进制，注意一些细节，要减一
     * */

    public static void main(String[] args) {
        int n = 26;
        String res = new ExcelSheetColumnTitle().convertToTitle(n);
        System.out.println(res);
    }
}
