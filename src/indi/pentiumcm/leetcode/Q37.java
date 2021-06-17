package indi.pentiumcm.leetcode;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.leetcode
 * @className: Q37
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2021/3/13 21:12
 * @describe: leetcode —— 978. 最长湍流子数组
 */
public class Q37 {


    public int maxTurbulenceSize(int[] arr) {
        int len = arr.length;
        if (len < 3) {
            return 1;
        }
        // 1. 将原问题转化为子问题
        // 长度为 0，1，2，3。。。。时最大湍流子数组的长度。

        // 2. 确定状态
        // dp[i]：前i个元素序列，且序列结尾为 nums[i] 时，最大湍流子数组的长度。
        int[] dp = new int[len];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }

        // 3. 确定初始状态
        dp[0] = 1;

        int maxAns = 0;

        // 4. 确定状态转移方程
        for (int i = 2; i < len; i++) {
            dp[i] = 2;

            int a1 = arr[i - 2];
            int a2 = arr[i - 1];
            int a3 = arr[i];

            if (a1 > a2 && a3 > a2) {
                dp[i] = dp[i - 1] + 1;
            }
            if (a1 < a2 && a3 < a2) {
                dp[i] = dp[i - 1] + 1;
            }
            maxAns = Math.max(maxAns, dp[i]);
        }

        return maxAns;
    }


    public static void main(String[] args) {

        int[] arr = {37, 199, 60, 296, 257, 248, 115, 31, 273, 176};

        int i = new Q37().maxTurbulenceSize(arr);

        System.out.printf("" + i);
    }

}
