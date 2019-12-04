package _java.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhaoweiguo
 * @date 2019-09-13
 */
public class RomanToInteger {
    /**
     * problem 13.
     * https://leetcode-cn.com/problems/roman-to-integer/
     *
     * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
     *      字符          数值
     *      I             1
     *      V             5
     *      X             10
     *      L             50
     *      C             100
     *      D             500
     *      M             1000
     *
     * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
     *
     * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。
     * 数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。
     * 这个特殊的规则只适用于以下六种情况：
     *      I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     *      X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
     *      C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     *
     * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
     *
     * 示例 1:
     * 输入: "III"
     * 输出: 3
     *
     * 示例 2:
     * 输入: "IV"
     * 输出: 4
     *
     * 示例 3:
     * 输入: "IX"
     * 输出: 9
     *
     * 示例 4:
     * 输入: "LVIII"
     * 输出: 58
     * 解释: L = 50, V= 5, III = 3.
     *
     * 示例 5:
     * 输入: "MCMXCIV"
     * 输出: 1994
     * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
     * */

    public int romanToInt(String s) {
        Map<Character, Integer> romanValues = new HashMap<>();
        romanValues.put('I', 1);
        romanValues.put('V', 5);
        romanValues.put('X', 10);
        romanValues.put('L', 50);
        romanValues.put('C', 100);
        romanValues.put('D', 500);
        romanValues.put('M', 1000);

        int value = 0;
        int firstValue = 0;
        int nextValue = 0;
        for (int i = 0; i < s.length(); i++) {
            firstValue = romanValues.get(s.charAt(i));

            if(i == s.length()-1) {
                value += firstValue;
                break;
            }

            nextValue = romanValues.get(s.charAt(i+1));
            if(nextValue > firstValue){
                value -= firstValue;
            } else {
                value += firstValue;
            }
        }

        return value;
    }

    /**
     * 思路：
     * 因为只有加减两种情况；执行下述逻辑的前提是输入是符合要求的
     *
     * - 加：当前符号 大于 下个符号
     * - 减：当前符号 小于 下个符号
     *
     * - 注意字符串最终的边界
     * */

    public static void main(String[] args) {
        String s = "IV";

        // 输入必须符合罗马数字的要求
        RomanToInteger obj = new RomanToInteger();
        int res = obj.romanToInt(s);
        System.out.println(res);
    }
}
