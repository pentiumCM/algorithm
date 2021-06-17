package indi.pentiumcm.leetcode;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.leetcode
 * @className: Q36
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2021/3/13 15:48
 * @describe: leetcode —— 300. 最长递增子序列
 */
public class Q36 {


    public int lengthOfLIS(int[] nums) {

        int len = nums.length;
        if (len == 0) {
            return 0;
        }

        // 1. 将原问题转化为子问题
        // 长度为 0，1，2，3。。。。时最长递增子序列长度

        // 2. 确定状态
        // dp[i]：前i个元素序列，且序列结尾为 nums[i] 时，最长递增子序列长度
        int[] dp = new int[len];

        // 3. 确定初始状态
        dp[0] = 1;

        int maxAns = 1;

        // 4. 确定状态转移方程
        for (int i = 1; i < len; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxAns = Math.max(maxAns, dp[i]);
        }
        return maxAns;
    }


    public static void main(String[] args) {

        int[] arr = {0, 1, 0, 3, 2, 3};

        int i = new Q36().lengthOfLIS(arr);

        System.out.printf("" + i);
    }

}
