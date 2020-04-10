package indi.pentiumcm.nowcoder.bytedance;

import java.util.Scanner;

import static java.lang.Double.POSITIVE_INFINITY;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.nowcoder
 * @className: Byte_19_5
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2020/4/10 9:22
 * @describe: 毕业旅行问题
 */
public class Byte_19_5 {

    // 无穷大
    static int MAX = (int) POSITIVE_INFINITY / 2;


    /**
     * 最小开销
     */
    public int minPri = MAX;
    /**
     * 当前路径的开销
     */
    public int curPri = 0;

    public int count = 0;


    /**
     * 动态规划 - 解决旅行商问题
     *
     * @param prices
     * @return
     */
    public int dpTsp(int[][] prices) {
        int cityNums = prices.length;

//      1. 将原问题划分为子问题
//          原问题：从城市 0 出发，经过{1,2,3},回到0
//          子问题：从城市 0 出发，到达城市 1,然后从 1 出发经过{2,3}，回到0

//      2. 定义状态，d[i][j]：i - 城市0，j - {1,2,3,4}等，从 i 出发，经过 j 城市，最后回到起点
        int colums = 1 << cityNums - 1;
        int[][] dp = new int[cityNums][colums];

//      3. 定义初始状态：dp[i][0] = Ci0
        for (int i = 0; i < cityNums; i++) {
            dp[i][0] = prices[i][0];
        }

//      4. 状态转移方程，dp[i][j] = min{Cik + dp[k][j-k]}
//       按列 j 来遍历dp表要经过的顶点集{j}
        for (int j = 1; j < colums; j++) {
//          按行来遍历当前的起点城市 k
            for (int i = 0; i < cityNums; i++) {
                dp[i][j] = MAX;

//              判断{j}中是否包含顶点 i，包含就代表已经到达过 i
                if (((j >> (i - 1)) & 1) == 1) {
                    continue;
                }

//              分别从剩余顶点中取 i 下一步要到达的城市 k
                for (int k = 1; k < cityNums; k++) {
//                  {j}的顶点集中含有顶点 k, dp[i][j] = Cik + dp[k][j-k]
                    if (((j >> (k - 1)) & 1) == 1) {
                        if (dp[i][j] > prices[i][k] + dp[k][j ^ (1 << (k - 1))]) {
                            dp[i][j] = prices[i][k] + dp[k][j ^ (1 << (k - 1))];
                        }
                    }
                }
            }
        }

        return dp[0][colums - 1];
    }


    /**
     * 回溯法 - 解决旅行商问题
     *
     * @param n      已经遍历多少个城市
     * @param k      当前选择的起点城市
     * @param prices
     * @param path   城市选择情况
     * @return
     */
    public int btTsp(int n, int k, int[][] prices, int[] path) {
//      遍历到最后一个城市
        if (n == path.length - 1) {

            curPri += prices[k][0];

            if (minPri > curPri) {
                minPri = curPri;
                curPri -= prices[k][0];
                return minPri;
            }
            curPri -= prices[k][0];
        }

//      方案数为城市数
        for (int i = 1; i < prices.length; i++) {
//          如果第 i 个城市还没有被选
            if (path[i] == 0) {
                path[i] = 1;

                curPri += prices[k][i];

                btTsp(n + 1, i, prices, path);

//              回溯
                curPri -= prices[k][i];
                path[i] = 0;
            }
        }
        return minPri;
    }


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);


//      城市个数
        int cityNums = in.nextInt();

//      path[i]：判断城市 i 是否走过
        int[] path = new int[cityNums];

        int[][] prices = new int[cityNums][cityNums];

        for (int i = 0; i < cityNums; i++) {
            for (int j = 0; j < cityNums; j++) {
                prices[i][j] = in.nextInt();

                prices[i][j] = prices[i][j] == 0 ? MAX : prices[i][j];
            }
        }

//      动态规划求得的最优解
        int dpMinPrice = new Byte_19_5().dpTsp(prices);

//      回溯法求得的最优解
        int btMinPrice = new Byte_19_5().btTsp(0, 0, prices, path);
        System.out.print(dpMinPrice);
        System.out.print(btMinPrice);
    }
}
