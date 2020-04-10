package indi.pentiumcm.thought;

import java.util.ArrayList;
import java.util.List;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.thought
 * @className: DpBack
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2020/3/25 23:38
 * @describe: 动态规划 - 0/1背包问题
 */
public class DpBack {


    /**
     * 0/1背包算法实现
     *
     * @param backCap 背包的容量
     * @param weights 物品的重量数组
     * @param values  物品的价值数组
     * @return
     */
    public void backPro(int backCap, int[] weights, int[] values) {

//      物品个数
        int goodNum = weights.length;

//      1. 确定状态
//      dp[i][j] 表示前i件物品放入重量为j的背包时的最大价值
        int[][] dp = new int[goodNum + 1][backCap + 1];

//      2. 确定一些初始状态：dp[0][0~backCap]=0，dp[0~goodNum][0]=0
        for (int i = 0; i <= backCap; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i <= goodNum; i++) {
            dp[i][0] = 0;
        }

//      3.确定状态转移方程：dp[i][j] = max(dp[i-1][j],dp[i-1][j-w[i]]+v[i]);
        for (int i = 1; i <= goodNum; i++) {
//          j 从 1 遍历到背包容量
            for (int j = 1; j <= backCap; j++) {
                if (weights[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i - 1]] + values[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }


//      回溯，看背包里面放了哪些物品
        int tempCap = backCap;
        List<Integer> backList = new ArrayList<>();
        for (int i = goodNum; i > 0; i--) {
            if (dp[i][tempCap] != dp[i - 1][tempCap]) {
                backList.add(i);
                tempCap -= weights[i - 1];
            }

        }

        System.out.print("背包中放了物品：");
        for (int i = backList.size() - 1; i >= 0; i--) {
            System.out.print(" " + backList.get(i));
        }


        System.out.print("\n" + "获得的最大价值为: " + dp[goodNum][backCap]);
    }

    public static void main(String[] args) {
//      背包容量
        int backCap = 8;
//      物品的重量
        int[] weights = {2, 3, 4, 5};
//      物品的价值
        int[] values = {3, 4, 5, 6};

        new DpBack().backPro(backCap, weights, values);
    }
}
