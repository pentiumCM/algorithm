package indi.pentiumcm.nowcoder.bytedance.test;

import java.util.Scanner;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.nowcoder.bytedance.exam
 * @className: Main2
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2021/3/21 9:49
 * @describe:
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int[] as = new int[N];
        for (int i = 0; i < N; i++) {
            as[i] = in.nextInt();
        }

        // 动态规划,dp[i][j],包含j,前面为 i-1 个数
        int[][] dp = new int[M + 1][N];

        for (int i = 0; i <= M; i++) {
            dp[i][0] = Math.max(as[0], 0);
        }
        for (int i = 0; i < N; i++) {
            dp[0][i] = as[i];
        }

        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                dp[i][j] = Math.max(as[j], dp[i - 1][j] + as[j]);
            }
        }
        int[] res = dp[M - 1];


        int ans = 0;


        for (int i = 0; i < N; i++) {
            System.out.println(res[i]);
            if (res[i] > ans) {
                ans = res[i];
            }
        }
        System.out.println(ans);
    }
}

