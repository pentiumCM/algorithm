package indi.pentiumcm.leetcode;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.leetcode
 * @className: Q16
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2020/4/1 15:31
 * @describe: 70. 爬楼梯
 */
public class Q16 {

    public int climbStairs(int n) {

        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }

//      1. 原问题划分为子问题
//          原问题：当序列长度为 n 时，求最大和
//          子问题：当序列长度为 n -1 时，求最大和
//          子问题：当序列长度为 n -2 时，求最大和

//      2. 定义状态：dp[i]为当楼梯数为 i 时，有多少个上楼梯方式
        int[] dp = new int[n + 1];

//      3. 定义初始状态
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

//      4. 状态转移方程：dp[i] = dp[i-1] + dp[i-2]
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
