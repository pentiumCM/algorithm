# 动态规划

## 一、解题套路

1. 将原问题转化为子问题：

2. 确定状态
3. 确定初始状态（边界状态）
4. 确定状态转移方程：
   

## 二、示例

```
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
```
