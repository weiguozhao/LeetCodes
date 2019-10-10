package javalanguage.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaoweiguo
 * @date 2019-10-07
 */
public class ZigZagConversion {
    /**
     * problem 6
     * https://leetcode-cn.com/problems/zigzag-conversion/
     */
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        List<StringBuilder> rows = new ArrayList<>();
        // 这里判断可以用 min(numRows, s.length())
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        boolean goingDown = false;
        int rowsIndex = 0;

        for (int i = 0; i < s.length(); i++) {
            rows.get(rowsIndex).append(s.charAt(i));
            if (rowsIndex == 0 || rowsIndex == numRows - 1) {
                goingDown = !goingDown;
            }
            rowsIndex += goingDown ? 1 : -1;
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            res.append(rows.get(i).toString());
        }
        return res.toString();
    }


    public static void main(String[] args) {

    }
}
