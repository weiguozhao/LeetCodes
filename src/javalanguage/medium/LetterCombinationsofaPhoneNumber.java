package javalanguage.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhaoweiguo
 * @date 2019-10-15
 */
public class LetterCombinationsofaPhoneNumber {
    /**
     * problem 17
     * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
     */
    private List<String> res;
    private Map<Character, String> num2Letter;

    public List<String> letterCombinations(String digits) {
        num2Letter = new HashMap<>();
        num2Letter.put('2', "abc");
        num2Letter.put('3', "def");
        num2Letter.put('4', "ghi");
        num2Letter.put('5', "jkl");
        num2Letter.put('6', "mno");
        num2Letter.put('7', "pqrs");
        num2Letter.put('8', "tuv");
        num2Letter.put('9', "wxyz");

        res = new ArrayList<>();
        if (digits.length() < 1){
            return res;
        }
        combineLetters(digits, 0, new StringBuilder());
        return res;
    }

    private void combineLetters(String digits, int index, StringBuilder last) {
        if (index == digits.length()) {
            res.add(last.toString());
            return;
        }

        String letters = num2Letter.get(digits.charAt(index));
        for (int j = 0; j < letters.length(); j++) {
            last.append(letters.charAt(j));
            combineLetters(digits, index + 1, last);
            last.deleteCharAt(last.length() - 1);
        }
    }

    public static void main(String[] args) {
        String digits = "23";
        List<String> res = new LetterCombinationsofaPhoneNumber().letterCombinations(digits);
        for (String str : res) {
            System.out.println(str);
        }
    }
}
