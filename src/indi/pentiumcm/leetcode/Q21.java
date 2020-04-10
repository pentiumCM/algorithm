package indi.pentiumcm.leetcode;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.leetcode
 * @className: Q21
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2020/4/8 9:27
 * @describe:
 */
public class Q21 {

    /**
     * 求一个数的各个位的和
     *
     * @param n
     * @return
     */
    public int digSum(int n) {
        int res = 0;
        res += n % 10;
        while (n / 10 > 0) {
            n = n / 10;
            res += n % 10;
        }
        return res;
    }

    public int movingCount(int m, int n, int k) {
//      1. 原问题划分为子问题
//         原问题：数位之和不大于k 能进入的格子
//         子问题：数位之和不大于k-1 能进入的格子
//         子问题：数位之和不大于k-2 能进入的格子
//         ........
//         子问题：数位之和不大于0 能进入的格子


//      2. 定义状态，dp[i][j]：(i,j)这个点是否可以到达
//        dp[i][j] = 0：不可到达，dp[i][j] = 1可到达
        int[][] dp = new int[m][n];


//      3. 定义初始状态
        dp[0][0] = 1;

        int ans = 0;

//      4. 状态转移方程：(i,j)可到达的话：dp[i][j] = dp[i - 1][j] | dp[i][j - 1]
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (digSum(i) + digSum(j) <= k) {
                    if (i - 1 >= 0) {
                        dp[i][j] |= dp[i - 1][j];
                    }
                    if (j - 1 >= 0) {
                        dp[i][j] |= dp[i][j - 1];
                    }
                } else {
                    dp[i][j] = 0;
                }
                ans += dp[i][j];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Q21 q21 = new Q21();
        int count = q21.movingCount(16, 16, 9);


    }
}
