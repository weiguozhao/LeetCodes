package javalanguage.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaoweiguo
 * @date 2019-10-17
 */
public class GenerateParentheses {
    /**
     * problem 22
     * https://leetcode-cn.com/problems/generate-parentheses/
     */
    private List<String> res;

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        generateParenthesisMine(n, 0, 0, "");
        return res;
    }

    private void generateParenthesis(int n, int left, int right, String stringBuilder) {
        if (stringBuilder.length() == n * 2) {
            res.add(stringBuilder.toString());
            return;
        }

        if (left < n) {
            generateParenthesis(n, left + 1, right, stringBuilder + "(");
        }
        if (right < left) {
            generateParenthesis(n, left, right + 1, stringBuilder + ")");
        }
    }

    private void generateParenthesisMine(int n, int left, int right, String stringBuilder) {
        if (left > n) {
            return;
        }

        if (left == right) {
            if (left == n) {
                res.add(stringBuilder.toString());
            } else {
                generateParenthesisMine(n, left + 1, right, stringBuilder + "(");
            }
        } else if (left > right) {
            generateParenthesisMine(n, left, right + 1, stringBuilder + ")");

            if (left < n) {
                generateParenthesisMine(n, left + 1, right, stringBuilder + "(");
            }
        }
    }

    public static void main(String[] args) {
        int n = 2;
        List<String> res = new GenerateParentheses().generateParenthesis(n);
        for (String str : res) {
            System.out.println(str);
        }
    }
}
