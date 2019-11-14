package javalanguage.medium;

/**
 * @author zhaoweiguo
 * @date 2019-11-12
 */
public class MultiplyStrings {
    /**
     * problem 43
     * https://leetcode-cn.com/problems/multiply-strings/
     *
     * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
     *
     * 示例 1:
     * 输入: num1 = "2", num2 = "3"
     * 输出: "6"
     *
     * 示例 2:
     * 输入: num1 = "123", num2 = "456"
     * 输出: "56088"
     *
     * 说明：
     * num1 和 num2 的长度小于110。
     * num1 和 num2 只包含数字 0-9。
     * num1 和 num2 均不以零开头，除非是数字 0 本身。
     * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
     */
    public String multiply(String num1, String num2) {
        String zero = "0";
        if (num1.equals(zero) || num2.equals(zero)) {
            return zero;
        }
        String res = "0";
        String operator = num1.length() < num2.length() ? num1 : num2;
        String factor = num1.length() < num2.length() ? num2 : num1;
        for (int i = operator.length() - 1; i >= 0; i--) {
            StringBuilder tempRes = multiply(factor, operator.charAt(i));

            int zeroTail = operator.length() - 1 - i;
            while (zeroTail-- != 0) {
                tempRes.append('0');
            }

            res = add(res, tempRes.toString());
        }
        return res;
    }

    private StringBuilder multiply(String num, char x) {
        StringBuilder sb = new StringBuilder();
        if (x == '0') {
            return sb.append('0');
        }
        if (x == '1') {
            return sb.append(num);
        }

        int carry = 0, numx = x - '0';
        for (int i = num.length() - 1; i >= 0; i--) {
            int mul = (num.charAt(i) - '0') * numx + carry;
            carry = mul / 10;
            sb.append((char) (mul % 10 + '0'));
        }
        if (carry != 0) {
            sb.append((char) (carry + '0'));
        }
        return sb.reverse();
    }

    private String add(String num1, String num2) {
        int carry = 0, i, j;
        StringBuilder sb = new StringBuilder();

        for (i = num1.length() - 1, j = num2.length() - 1; i >= 0 && j >= 0; i--, j--) {
            int sum = num1.charAt(i) - '0' + num2.charAt(j) - '0' + carry;
            carry = sum / 10;
            sb.append((char) (sum % 10 + '0'));
        }
        while (i >= 0) {
            int sum = num1.charAt(i) - '0' + carry;
            carry = sum / 10;
            sb.append((char) (sum % 10 + '0'));
            i--;
        }
        while (j >= 0) {
            int sum = num2.charAt(j) - '0' + carry;
            carry = sum / 10;
            sb.append((char) (sum % 10 + '0'));
            j--;
        }
        if (carry != 0) {
            sb.append((char) (carry + '0'));
        }
        return sb.reverse().toString();
    }

    /**
     * 1. 计算每个位置的乘积(暂时不处理进位)，每个位最大是9*9=81
     * 2. 从低位开始，处理进位
     * 3. 将数组中的每个数字转化成String输出
     */
    public String goodSolution(String num1, String num2) {
        String zero = "0";
        if (num1.equals(zero) || num2.equals(zero)) {
            return zero;
        }

        int l1 = num1.length(), l2 = num2.length(), l = l1 + l2;
        char[] ans = new char[l];
        char[] c1 = num1.toCharArray();
        char[] c2 = num2.toCharArray();
        // 计算乘积, i表示被乘数, j表示乘数
        for (int i = l1 - 1; i >= 0; --i) {
            int c = c1[i] - '0';
            for (int j = l2 - 1; j >= 0; --j) {
                // index=i+j+1表示的是从数组的高位开始赋值，c1[i] * c2[j]的结果最多到达该位置
                ans[i + j + 1] += c * (c2[j] - '0');
            }
        }
        // 处理进位
        for (int i = l - 1; i > 0; --i) {
            if (ans[i] > 9) {
                ans[i - 1] += ans[i] / 10;
                ans[i] %= 10;
            }
        }
        // 转化成String
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (; ; ++i) {
            if (ans[i] != 0) {
                break;
            }
        }
        for (; i < ans.length; ++i) {
            sb.append((char) (ans[i] + '0'));
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        String num1 = "123456789";
        String num2 = "987654321";
        String res = new MultiplyStrings().multiply(num1, num2);
        System.out.println(res);
    }
}
