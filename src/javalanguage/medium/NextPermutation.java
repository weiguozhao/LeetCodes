package javalanguage.medium;

/**
 * @author zhaoweiguo
 * @date 2019-10-23
 */
public class NextPermutation {
    /**
     * problem 31
     * https://leetcode-cn.com/problems/next-permutation/
     * */
    /**
     * 作者：powcai
     * 链接：https://leetcode-cn.com/problems/next-permutation/solution/xia-yi-ge-pai-lie-by-powcai/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        // 先找出最大的索引 k 满足 nums[k] < nums[k+1]
        // 因为 k+1及之后部分已经是降序排列，没有下一个排列
        int firstIndex = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                firstIndex = i;
                break;
            }
        }
        // 如果不存在，就翻转整个数组，结束
        if (firstIndex == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        // 再找出另一个最大索引 l 满足 nums[l] > nums[k]
        // 下一个排列保证要比当前排列大，所以选择右侧第一个比 num[k] 大的值进行交换
        int secondIndex = -1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > nums[firstIndex]) {
                secondIndex = i;
                break;
            }
        }
        // 交换 nums[l] 和 nums[k]
        swap(nums, firstIndex, secondIndex);
        // 最后翻转 nums[k+1:]
        // 两个index交换后，由于原来的 k+1部分是降序排列的，现在要改成升序排列，确保该部分是排列的最小排列
        reverse(nums, firstIndex + 1, nums.length - 1);
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }

    private void swap(int[] nums, int i, int i1) {
        int tmp = nums[i];
        nums[i] = nums[i1];
        nums[i1] = tmp;
    }

    public static void main(String[] args) {

    }
}
