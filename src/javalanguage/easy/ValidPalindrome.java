package javalanguage.easy;

/**
 * @author zhaoweiguo
 * @date 2019-09-25
 */
public class ValidPalindrome {
    /**
     * problem 125
     * https://leetcode-cn.com/problems/valid-palindrome/
     */
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        for (int i = 0, j = s.length() - 1; i < j; ) {
            char left = s.charAt(i);
            char right = s.charAt(j);

            if (validCharacter(left) && validCharacter(right)) {
                if (left == right) {
                    i++;
                    j--;
                } else {
                    return false;
                }
            } else if (validCharacter(left)) {
                j--;
            } else if (validCharacter(right)) {
                i++;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }

    private boolean validCharacter(Character ch) {
        int cha = ch - 'a';
        int num = ch - '0';

        if (cha >= 0 && cha <= 26) {
            return true;
        } else if (num >= 0 && num < 10) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String s = "race a car";

        boolean res = new ValidPalindrome().isPalindrome(s);
        System.out.println(res);
    }
}
