package javalanguage.easy;

/**
 * @author zhaoweiguo
 * @date 2019-09-18
 */
public class AddBinary {
    /**
     * problem 67
     * https://leetcode-cn.com/problems/add-binary/
     * <p>
     * 给定两个二进制字符串，返回他们的和（用二进制表示）。
     * 输入为非空字符串且只包含数字 1 和 0。
     * <p>
     * 示例 1:
     * 输入: a = "11", b = "1"
     * 输出: "100"
     * <p>
     * 示例 2:
     * 输入: a = "1010", b = "1011"
     * 输出: "10101"
     */
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int carry = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            carry = carry + (i >= 0 ? a.charAt(i) - '0' : 0) + (j >= 0 ? b.charAt(j) - '0' : 0);
            res.append(carry % 2);
            carry /= 2;
        }
        if (carry > 0) {
            res.append(carry);
        }
        return res.reverse().toString();
    }


    public String addBinary_mine(String a, String b) {
        StringBuilder res = new StringBuilder();
        String carry = "0";
        int i, j;
        for (i = a.length() - 1, j = b.length() - 1; i >= 0 && j >= 0; i--, j--) {
            if (a.charAt(i) == '1' && b.charAt(j) == '1') {
                res.append(carry);
                carry = "1";
            } else if (a.charAt(i) == '0' && b.charAt(j) == '0') {
                res.append(carry);
                carry = "0";
            } else {
                if (carry == "0") {
                    res.append("1");
                } else {
                    res.append("0");
                }
            }
        }

        while (i >= 0) {
            if (carry == "1" && a.charAt(i) == '1') {
                res.append("0");
            } else if (carry == "0") {
                res.append(a.charAt(i));
            } else {
                carry = "0";
                res.append("1");
            }
            i--;
        }

        while (j >= 0) {
            if (carry == "1" && b.charAt(j) == '1') {
                res.append("0");
            } else if (carry == "0") {
                res.append(b.charAt(j));
            } else {
                carry = "0";
                res.append("1");
            }
            j--;
        }

        if (carry == "1") {
            res.append(carry);
        }

        return res.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "11";
        String b = "1";

        String res = new AddBinary().addBinary(a, b);
        System.out.println(res);
    }
}
