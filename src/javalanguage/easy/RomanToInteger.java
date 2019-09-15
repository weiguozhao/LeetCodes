package javalanguage.easy;

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
