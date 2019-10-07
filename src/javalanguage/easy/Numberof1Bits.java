package javalanguage.easy;

/**
 * @author zhaoweiguo
 * @date 2019-10-06
 */
public class Numberof1Bits {
    /**
     * problem 191
     * https://leetcode-cn.com/problems/number-of-1-bits/
     */
    public int hammingWeight(int n) {
        int res = 0, mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) == 1) {
                res++;
            }
            n >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int n =11;
        int res = new Numberof1Bits().hammingWeight(n);
        System.out.println(res);
    }
}
