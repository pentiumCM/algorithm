package indi.pentiumcm.leetcode;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.leetcode
 * @className: Q61
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2021/5/15 8:56
 * @describe:
 */
public class Q61 {

    public int minCount(int[] coins) {

        int ans = 0;

        for (int i = 0; i < coins.length; i++) {
            int item = coins[i];
            int div = item / 2;
            int ys = item % 2;

            ans = ans + div + ys;
        }

        return ans;
    }
}
