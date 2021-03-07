package indi.pentiumcm.leetcode;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.leetcode
 * @className: Q26
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2020/6/2 9:14
 * @describe: leetcode - 面试题64. 求1+2+…+n
 */
public class Q26 {

    /**
     * 动态规划求 n!
     *
     * @param n
     * @return
     */
    public int sumNums(int n) {
//        int res = dpSum(n);
        int res = logicalOpt(n);
        return res;
    }

    /**
     * 递归求 n！
     *
     * @param n
     * @return
     */
    public int dpSum(int n) {
        return n == 0 ? 0 : dpSum(n - 1) + n;
    }

    /**
     * 通过逻辑运算符的短路性来求 n!
     *
     * @param n
     * @return
     */
    public int logicalOpt(int n) {
        boolean flag = n > 0 && (n += logicalOpt(n - 1)) > 0;
        return n;
    }

    public static void main(String[] args) {
        int res1 = new Q26().sumNums(3);
        int res2 = new Q26().sumNums(9);

        System.out.println(res1);
        System.out.println(res2);
    }

}
