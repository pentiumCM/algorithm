package indi.pentiumcm.tags.dp;

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
        // 1. 将原问题转化为子问题
        // 求 fib(1)
        // .........
        // 求 fib(n)

        // 2. 确定状态
        // dp[i] 表示 fib(i) 的值
        long[] dp = new long[n + 1];

        // 3. 确定初始状态
        dp[1] = 1;
        dp[2] = 1;

        // 4. 确定状态转移方程
        for (int i = 3; i <= n; i++) {
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
        int n = 45;

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
