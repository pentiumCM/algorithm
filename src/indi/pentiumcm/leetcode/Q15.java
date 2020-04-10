package indi.pentiumcm.leetcode;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.leetcode
 * @className: Q15
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2020/4/1 10:55
 * @describe: 53. 最大子序和 - 动态规划解决
 */
public class Q15 {

    /**
     * 动态规划解决
     *
     * @param nums
     */
    public void maxSubArray(int[] nums) {

//      1. 原问题划分为子问题
//      原问题：当序列长度为 n 时，求最大和
//      子问题：当序列长度为 n -1 时，求最大和
//      子问题：当序列长度为 n -2 时，求最大和

//      2. 定义状态：dp[i]为 遍历到第 i 个元素时，子串的最大和
        int[] dp = new int[nums.length];

//      3. 初始状态 dp[0] = nums[0]
        dp[0] = nums[0];

//      4. 状态转移方程：dp[i] = max{dp[i-1] + nums[i], nums[i]}
        for (int i = 1; i < nums.length; i++) {
            int maxSum = dp[i - 1] + nums[i] > nums[i] ? dp[i - 1] + nums[i] : nums[i];
            dp[i] = maxSum;
        }

//      遍历dp[]，dp[]最大的值即为连续子串的最大和
        int maxSum = dp[0];
        int maxIndex = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > maxSum) {
                maxSum = dp[i];
                maxIndex = i;
            }
        }

        System.out.println("最大子串和：" + dp[maxIndex]);

//      回溯, 求最大连续子串的元素
        System.out.print("最大连续子串元素：");
        for (int i = maxIndex; i >= 0; i--) {
            if (maxSum == nums[i]) {
                System.out.print(" " + nums[i]);
                break;
            } else {
                maxSum -= nums[i];
                System.out.print(" " + nums[i]);
            }
        }
    }


    /**
     * 贪心算法
     *
     * @param nums
     * @return
     */
    public int maxSubArrayV2(int[] nums) {
        int maxSum = 0, curSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curSum = Math.max(nums[i], curSum + nums[i]);
            maxSum = Math.max(maxSum, curSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        new Q15().maxSubArrayV2(arr);
    }
}
