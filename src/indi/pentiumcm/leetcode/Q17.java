package indi.pentiumcm.leetcode;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.leetcode
 * @className: Q17
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2020/4/2 15:38
 * @describe: 122. 买卖股票的最佳时机 II
 */
public class Q17 {


    /**
     * 贪心策略来实现
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int maxIncome = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            int income = prices[i + 1] - prices[i] > 0 ? prices[i + 1] - prices[i] : 0;
            maxIncome += income;
        }

        return maxIncome;
    }


    /**
     * 动态规划来实现
     *
     * @param prices
     * @return
     */
    public int maxProfitV2(int[] prices) {
//      剪枝处理
        if (prices.length <= 1) {
            return 0;
        }
        if (prices.length == 2) {
            return prices[1] - prices[0] > 0 ? prices[1] - prices[0] : 0;
        }


//      1. 原问题划分为子问题
//         原问题：n天中股票最大收益
//         子问题：n-1中股票最大收益
//         子问题：n-2天中股票最大收益


//      2. 定义状态：dp[i] - 第 i 天的股票最大收益
        int[] dp = new int[prices.length + 1];

//      3. 定义初始状态
        dp[0] = 0;
        dp[1] = 0;

//      4. 状态转移方程：dp[i] = dp[i-1] + 第i天当天的收益
        for (int i = 2; i <= prices.length; i++) {
            int income = prices[i - 1] - prices[i - 2] > 0 ? prices[i - 1] - prices[i - 2] : 0;
            dp[i] = dp[i - 1] + income;
        }

        return dp[prices.length];
    }


    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4, 5};
        int income = new Q17().maxProfitV2(arr);
    }
}
