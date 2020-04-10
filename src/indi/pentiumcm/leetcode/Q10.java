package indi.pentiumcm.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.leetcode
 * @className: Q10
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2020/3/24 9:05
 * @describe: 17.16. 按摩师
 */
public class Q10 {


    public int massage(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }

        // dp[i][0]：下标为 i 的这一天不接受预约的最大时长
        // dp[i][1]：下标为 i 的这一天接受预约的最大时长
        int[][] dp = new int[len][2];

        dp[0][0] = 0;
        dp[0][1] = nums[0];

        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];

        }
        return Math.max(dp[len - 1][0], dp[len - 1][1]);
    }

    public static void main(String[] args) {
        Q10 solution = new Q10();
        int[] nums = {2, 1, 4, 5, 3, 1, 1, 3};
        int res = solution.massage(nums);
        System.out.println(res);
    }
}

