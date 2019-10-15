package javalanguage.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaoweiguo
 * @date 2019-10-14
 */
public class IntegertoRoman {
    /**
     * problem 12
     * https://leetcode-cn.com/problems/integer-to-roman/
     */
    public String intToRoman(int num) {
        List<NumToRoman> numToRoman = new ArrayList<NumToRoman>();
        numToRoman.add(new NumToRoman(1, "I"));
        numToRoman.add(new NumToRoman(4, "IV"));
        numToRoman.add(new NumToRoman(5, "V"));
        numToRoman.add(new NumToRoman(9, "IX"));
        numToRoman.add(new NumToRoman(10, "X"));
        numToRoman.add(new NumToRoman(40, "XL"));
        numToRoman.add(new NumToRoman(50, "L"));
        numToRoman.add(new NumToRoman(90, "XC"));
        numToRoman.add(new NumToRoman(100, "C"));
        numToRoman.add(new NumToRoman(400, "CD"));
        numToRoman.add(new NumToRoman(500, "D"));
        numToRoman.add(new NumToRoman(900, "CM"));
        numToRoman.add(new NumToRoman(1000, "M"));

        StringBuilder stringBuilder = new StringBuilder();
        for(int i = numToRoman.size()-1; i >= 0; i--){
            int count = num / numToRoman.get(i).num;
            while(count != 0){
                stringBuilder.append(numToRoman.get(i).id);
                count--;
            }
            num %= numToRoman.get(i).num;
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        int num = 6;
        String res = new IntegertoRoman().intToRoman(num);
        System.out.println(res);
    }
}

class NumToRoman{
    public int num;
    public String id;
    public NumToRoman(int n, String i){
        this.num = n;
        this.id = i;
    }
}