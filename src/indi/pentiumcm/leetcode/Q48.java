package indi.pentiumcm.leetcode;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.leetcode
 * @className: Q48
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2021/4/28 9:58
 * @describe: 633. 平方数之和
 */
public class Q48 {

    public static boolean judgeSquareSum(int c) {
        int mid = (int) Math.sqrt(c);
        for (int i = 0; i <= mid; i++) {
            double b = Math.sqrt(c - Math.pow(i, 2));
            int intB = (int) b;
            if (b == intB) {
                return true;
            }
        }
        return false;
    }

    public static boolean judgeSquareSum_V2(int c) {
        int left = 0;
        int right = (int) Math.sqrt(c);
        while (left <= right) {
            int add = (int) (Math.pow(left, 2) + Math.pow(right, 2));
            if (add == c) {
                return true;
            } else if (add < c) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int src = 18;

        boolean b = judgeSquareSum_V2(src);
        System.out.println(b);
    }
}
