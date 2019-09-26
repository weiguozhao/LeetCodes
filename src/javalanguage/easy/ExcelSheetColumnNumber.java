package javalanguage.easy;

/**
 * @author zhaoweiguo
 * @date 2019-09-26
 */
public class ExcelSheetColumnNumber {
    /**
     * problem 171
     * https://leetcode-cn.com/problems/excel-sheet-column-number/
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
