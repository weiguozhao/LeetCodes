package easy;

/**
 * @author zhaoweiguo
 * @date 2019-09-13
 */
public class ReverseInteger {
    public int temperse(int x) {
        int tailMaxInt = Integer.MAX_VALUE % 10;
        int tailMinInt = Integer.MIN_VALUE % 10;

        int temp = 0;

        while (x != 0) {
            int pop = x % 10;
            x /= 10;

            // positve number
            if (temp > Integer.MAX_VALUE / 10 || (temp == Integer.MAX_VALUE / 10 && pop > tailMaxInt)) {
                return 0;
            }
            // negative number
            if (temp < Integer.MIN_VALUE / 10 || (temp == Integer.MIN_VALUE / 10 && pop < tailMinInt)) {
                return 0;
            }

            temp = temp * 10 + pop;
        }

        return temp;
    }

    /**
     * 重点在于分析溢出的条件(以temp为正数为例)：
     *
     * 如果 temp * 10 + pop 导致溢出，那么一定有 temp * 10 >= MAX_INT
     *
     * 然后分两种情况讨论：
     * if (temp*10 > MAX_INT) => temp*10+pop 一定会溢出，需要返回0
     * if (temp*10 == MAX_INT) => pop > MAX_INT%10 一定会溢出，需要返回0
     *
     * 注意：
     * 先判断之后赋值会不会溢出，再进行运算
     * */

    public static void main(String[] args) {
        int x = 123;

        ReverseInteger obj = new ReverseInteger();
        int res = obj.temperse(x);

        System.out.println(res);
    }
}
