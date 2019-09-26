package javalanguage.easy;

/**
 * @author zhaoweiguo
 * @date 2019-09-25
 */
public class TwoSumII_Inputarrayissorted {
    /**
     * problem 167
     * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
     */
    public int[] twoSum(int[] numbers, int target) {
        int i, j, add;
        for (i = 0, j = numbers.length - 1; i < j; ) {
            add = numbers[i] + numbers[j];
            if (add == target) {
                break;
            } else if (add > target) {
                j--;
            } else {
                i++;
            }
        }
        return new int[]{i + 1, j + 1};
    }


    public static void main(String[] args) {

    }
}
