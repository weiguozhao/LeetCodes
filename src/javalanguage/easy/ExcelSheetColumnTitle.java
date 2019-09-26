package javalanguage.easy;

/**
 * @author zhaoweiguo
 * @date 2019-09-25
 */
public class ExcelSheetColumnTitle {
    /**
     * problem 168
     * https://leetcode-cn.com/problems/excel-sheet-column-title/
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
