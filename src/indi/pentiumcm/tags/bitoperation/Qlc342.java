package indi.pentiumcm.tags.bitoperation;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.leetcode
 * @className: Q342
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2021/5/31 9:17
 * @describe: leetcode 342. 4的幂
 * https://leetcode-cn.com/problems/power-of-four/solution/4de-mi-by-leetcode-solution-b3ya/
 */
public class Qlc342 {
    public static boolean isPowerOfFour(int n) {
        for (int i = 0; i <= n; i++) {
            double cal = Math.pow(4, i);
            if (cal == n) {
                return true;
            } else if (cal > n) {
                return false;
            }
        }
        return false;
    }
}
