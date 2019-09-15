package javalanguage.easy;

/**
 * @author zhaoweiguo
 * @date 2019-09-15
 */
public class RemoveElement {
    /**
     * problem 27.
     * https://leetcode-cn.com/problems/remove-element/
     */
    public int removeElement(int[] nums, int val) {
        // 头指针
        int i = 0;
        // 尾指针
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                // 将尾部的数值拿到当前位置，相当于删除了当前的值
                nums[i] = nums[n - 1];
                // reduce array size by one
                n--;
            } else {
                i++;
            }
        }
        return n;
    }

    public int removeElement_mine(int[] nums, int val) {
        if (nums.length < 1) {
            return nums.length;
        }

        int point = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[point] = nums[i];
                point++;
            }
        }
        return point;
    }

    /**
     * 思考：
     * 当删除的元素很少时，不必要的赋值操作会浪费很大的时间
     *
     * 考虑将要删除的元素和末尾的元素进行交换
     * */

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;

        int res = new RemoveElement().removeElement(nums, val);
        System.out.println(res);
        for(int i=0; i<res; i++){
            System.out.print(nums[i] + " ");
        }
    }
}
