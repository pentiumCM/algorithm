package indi.pentiumcm.leetcode;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.leetcode
 * @className: Q51
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2021/5/4 15:41
 * @describe: 1480. 一维数组的动态和
 */
public class Q51 {

    public static int[] runningSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        int[] ans = new int[nums.length];
        ans[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            ans[i] = ans[i - 1] + nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] runningSum = runningSum(nums);

        System.out.println(runningSum);
    }
}
