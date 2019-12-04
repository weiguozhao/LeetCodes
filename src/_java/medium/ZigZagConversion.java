package _java.medium;

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
     *
     * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
     * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
     *
     *      L   C   I   R
     *      E T O E S I I G
     *      E   D   H   N
     *
     * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
     *
     * 请你实现这个将字符串进行指定行数变换的函数：
     * string convert(string s, int numRows);
     *
     * 示例 1:
     * 输入: s = "LEETCODEISHIRING", numRows = 3
     * 输出: "LCIRETOESIIGEDHN"
     *
     * 示例 2:
     * 输入: s = "LEETCODEISHIRING", numRows = 4
     * 输出: "LDREOEIIECIHNTSG"
     * 解释:
     *      L     D     R
     *      E   O E   I I
     *      E C   I H   N
     *      T     S     G
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
