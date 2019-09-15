package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhaoweiguo
 * @date 2019-09-13
 */
public class TwoSum {
    /**
     * problem 1.
     * https://leetcode-cn.com/problems/two-sum/
     * */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numIndex = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            Integer rest = target - nums[i];

            if (numIndex.containsKey(rest)){
                return new int[]{numIndex.get(rest), i};
            }

            numIndex.put(nums[i], i);
        }

        throw new IllegalArgumentException("No twoSum Solution.");
    }

    /**
     * 思考：本题是两数之和，如果是k个数之和呢？如果是有序数组呢？
     *
     * k数之和：
     *
     * 有序数组的两数之和：
     * 从两端到中间挤 O(n)
     *
     * 有序数组的k数之和：
     * */

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        TwoSum obj = new TwoSum();
        int[] res = obj.twoSum(nums, target);

        for(int i: res){
            System.out.println(i);
        }
    }
}
