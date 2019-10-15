package javalanguage.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhaoweiguo
 * @date 2019-10-14
 */
public class ThreeSum {
    /**
     * problem 15
     * https://leetcode-cn.com/problems/3sum/
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int k = 0; k < nums.length; k++) {
            if (k != 0 && nums[k] == nums[k - 1]) {
                continue;
            }
            for (int i = k + 1, j = nums.length - 1; i < j; ) {
                if (nums[k] + nums[i] + nums[j] == 0) {
                    List<Integer> sum3 = new ArrayList<>();
                    sum3.add(nums[k]);
                    sum3.add(nums[i]);
                    sum3.add(nums[j]);

                    res.add(sum3);
                    while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                        i++;
                    }
                    while (j > 0 && nums[j] == nums[j - 1]) {
                        j--;
                    }
                    i++; j--;
                } else if (nums[k] + nums[i] + nums[j] > 0) {
                    j--;
                } else {
                    i++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = new ThreeSum().threeSum(nums);
        for(List<Integer> inner: res){
            for(Integer num: inner){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
