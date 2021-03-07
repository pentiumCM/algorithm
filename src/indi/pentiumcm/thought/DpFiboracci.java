package indi.pentiumcm.thought;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.thought
 * @className: FiDp
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2020/9/7 22:06
 * @describe: 动态规划实现 斐波拉契数列
 */
public class DpFiboracci {


    /**
     * 递归解 斐波拉契数列
     *
     * @param n
     * @return
     */
    public static long originalFib(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        } else {
            return originalFib(n - 1) + originalFib(n - 2);
        }
    }


    /**
     * 动态规划求解 斐波拉契数列 - 自下而上
     *
     * @param n
     * @return
     */
    public static long dpFibB2U(int n) {

        // 1. 构建动态规划dp表
        long dp[] = new long[n + 1];

        // 2. 确定初始状态
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i < n + 1; i++) {
            // 3. 确定状态转移方程
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }


    /**
     * 动态规划求解 斐波拉契数列 - 自上而下
     * 加了一个缓存数组，记录计算过的值
     *
     * @param n
     * @param memory
     * @return
     */
    public static long dpFibU2B(int n, long[] memory) {
        if (n == 1 || n == 2) {
            return 1;
        }
        if (memory[n] == 0) {
            memory[n] = dpFibU2B(n - 1, memory) + dpFibU2B(n - 2, memory);
        }
        return memory[n];
    }


    public static void main(String[] args) {
        int n = 40;

        // 获取开始时间
        long startTime1 = System.currentTimeMillis();
        long res1 = originalFib(n);
        System.out.println(res1);
        // 获取结束时间
        long endTime1 = System.currentTimeMillis();
        //输出程序运行时间
        System.out.println("程序运行时间1：" + (endTime1 - startTime1) + "ms");


        long[] memory = new long[n + 1];
        // 获取开始时间
        long startTime2 = System.currentTimeMillis();
        long res2 = dpFibU2B(n, memory);
        System.out.println(res2);
        // 获取结束时间
        long endTime2 = System.currentTimeMillis();
        // 输出程序运行时间
        System.out.println("程序运行时间2：" + (endTime2 - startTime2) + "ms");


        // 获取开始时间
        long startTime3 = System.currentTimeMillis();
        long res3 = dpFibB2U(n);
        System.out.println(res3);
        // 获取结束时间
        long endTime3 = System.currentTimeMillis();
        // 输出程序运行时间
        System.out.println("程序运行时间3：" + (endTime3 - startTime3) + "ms");
    }
}
