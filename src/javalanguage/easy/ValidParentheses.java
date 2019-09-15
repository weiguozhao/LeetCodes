package javalanguage.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author zhaoweiguo
 * @date 2019-09-15
 */
public class ValidParentheses {
    /**
     * problem 20
     * https://leetcode-cn.com/problems/valid-parentheses/
     */

    public boolean isValid(String s) {
        // 如果奇数串无法配对
        if (s.length() % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        for (int i = 0; i < s.length(); i++) {
            Character character = s.charAt(i);
            switch (character) {
                case '(':
                case '{':
                case '[':
                    stack.push(character);
                    break;
                case ')':
                case '}':
                case ']':
                    if (!stack.isEmpty() && stack.peek().equals(map.get(character))) {
                        stack.pop();
                        break;
                    } else {
                        return false;
                    }
                default:
                    ;
            }
        }

        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 思路就是用一个stack来辅助判断
     * 细节：奇数长度串
     * */

    public static void main(String[] args) {
        String s = "()[]{}";

        boolean res = new ValidParentheses().isValid(s);
        System.out.println(res);
    }
}
