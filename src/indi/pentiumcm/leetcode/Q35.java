package indi.pentiumcm.leetcode;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.leetcode
 * @className: Q35
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2021/3/12 11:29
 * @describe: leetcode —— 474. 一和零
 */
public class Q35 {


    public int findMaxForm(String[] strs, int m, int n) {


        // 可以理解为背包问题：m个0，n个1


        // 共有 itemsNum 物体
        int itemsNum = strs.length;

        // 1. 确定状态 —— dp[k][i][j]为：表示前 k 个字符放入 i 个 0、j 个 1 时的最大子集个数
        int[][][] dp = new int[itemsNum + 1][m + 1][n + 1];

        // 2. 确定初始状态：dp[0][0~capNum]=0，dp[0~itemsNum][0]=0

        // 3.确定状态转移方程：dp[k][i][j] = max{dp[k-1][i][j],dp[k-1][i-w[k]][j-w[i]]+1};
        for (int k = 1; k <= itemsNum; k++) {
            String item = strs[k - 1];
            int[] countZero2One = countZero2One(item);

            // i 从 1 遍历到 m 个 0
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= n; j++) {
                    if (i >= countZero2One[0] && j >= countZero2One[1]) {
                        dp[k][i][j] = Math.max(dp[k - 1][i][j], dp[k - 1][i - countZero2One[0]][j - countZero2One[1]] + 1);
                    } else {
                        dp[k][i][j] = dp[k - 1][i][j];
                    }
                }
            }
        }
        return dp[itemsNum][m][n];
    }


    /**
     * 计算字符串中 0 和 1 的个数
     *
     * @param str
     * @return
     */
    public int[] countZero2One(String str) {
        int[] count = new int[2];
        if (str == null) {
            return count;
        }

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '0') {
                count[0]++;
            } else {
                count[1]++;
            }
        }
        return count;
    }


    public static void main(String[] args) {

        String[] strs = {"10", "0", "1"};

        Q35 q35 = new Q35();

        int maxForm = q35.findMaxForm(strs, 1, 1);

    }

}
