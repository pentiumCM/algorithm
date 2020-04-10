package indi.pentiumcm.nowcoder.bytedance;

import java.util.Scanner;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.nowcoder
 * @className: Byte_19_2
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2020/4/2 22:22
 * @describe: 万万没想到之抓捕孔连顺
 */
public class Byte_19_2 {


    /**
     * 动态规划解决
     *
     * @param loc
     * @param D
     * @return
     */
    public long sln(int[] loc, int D) {

        int len = loc.length;
        if (len < 3) {
            return 0;
        }

//      1. 原问题划分为子问题
//          原问题：当序列长度为 n 时，排列组合个数
//          子问题：当序列长度为 n -1 时，排列组合个数
//          子问题：当序列长度为 n -2 时，排列组合个数

//      2. 定义状态：dp[i]为当序列长数为 i 时，并且包含第 i 个元素的排列组合
        long[] dp = new long[loc.length];

//      3. 定义初始状态
        dp[0] = 0;
        dp[1] = 0;

        dp[2] = loc[2] - loc[0] <= D ? 1 : 0;

//      4. 状态转移方程
        for (int i = 3; i < len; i++) {
            int right = i, left = i - 2;
            long count = 0;

            while (left >= 0) {
                if (loc[right] - loc[left] < D) {
                    left--;
                } else {
                    break;
                }
            }

            left = left == -1 ? 0 : left;
            if (loc[right] - loc[left] > D) {
                left++;
            }

            count = Cn2(right - left);

            dp[i] = dp[i - 1] + count;
        }

        return dp[len - 1];
    }

    public long Cn2(long n) {
        if (n < 2) {
            return 0;
        }
        return n * (n - 1) / 2;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int D = in.nextInt();

        int[] loc = new int[N];
        for (int i = 0; i < N; i++) {
            loc[i] = in.nextInt();
        }

        long count = 0;
        count = new Byte_19_2().sln(loc, D);
        System.out.println((int) (count % 99997867));
    }
}
