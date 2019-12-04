package _java.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaoweiguo
 * @date 2019-09-16
 */
public class CountandSay {
    /**
     * problem 38
     * https://leetcode-cn.com/problems/count-and-say/
     *
     * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
     *
     * 1.     1
     * 2.     11
     * 3.     21
     * 4.     1211
     * 5.     111221
     * 1  被读作 "one 1"  ("一个一") , 即 11。
     * 11 被读作 "two 1s" ("两个一"）, 即 21。
     * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
     *
     * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
     *
     * 注意：整数顺序将表示为一个字符串。
     *
     * 示例 1:
     * 输入: 1
     * 输出: "1"
     *
     * 示例 2:
     * 输入: 4
     * 输出: "1211"
     */
    public String countAndSay(int n) {
        StringBuilder[] seq = new StringBuilder[n];
        seq[0] = new StringBuilder("1");
        for (int i = 1; i < n; i++) {
            seq[i] = convert(seq[i - 1]);
        }
        return new String(seq[n - 1]);
    }

    private StringBuilder convert(StringBuilder str) {
        StringBuilder ans = new StringBuilder();
        int len = str.length();
        int count = 1;
        for (int i = 0; i < len; i++) {
            // i<len-1，一方面控制i+1不越界，另一方面控制最后一个计数加到ans中
            // str.charAt(i) == str.charAt(i + 1)，后一个字符和当前字符相同
            if (i < len - 1 && str.charAt(i) == str.charAt(i + 1)) {
                count++;
            } else {
                ans.append(count).append(str.charAt(i));
                count = 1;
            }
        }
        return ans;
    }


    public String countAndSay_mine(int n) {
        if (n < 1) {
            return "";
        }

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("11");
        list.add("21");
        list.add("1211");

        while (n - 1 >= list.size()) {
            String lastCount = list.get(list.size() - 1);

            int count = 1;
            char temp = list.get(list.size() - 1).charAt(0);
            String thisCount = "";
            for (int i = 1; i < lastCount.length(); i++) {
                if (lastCount.charAt(i) == temp) {
                    count++;
                } else {
                    thisCount = thisCount + count + temp;

                    temp = lastCount.charAt(i);
                    count = 1;
                }
            }
            thisCount = thisCount + count + temp;

            list.add(thisCount);
        }
        return list.get(n - 1);
    }

    /**
     * 思路一致，细节要提高
     *
     * */

    public static void main(String[] args) {
        int n = 5;

        String res = new CountandSay().countAndSay(n);
        System.out.println(res);
    }
}
