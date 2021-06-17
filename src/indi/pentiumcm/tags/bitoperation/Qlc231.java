package indi.pentiumcm.tags.bitoperation;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.tags.bitoperation
 * @className: Qlc231
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2021/5/31 9:50
 * @describe: leetcode 231. 2 的幂
 * https://leetcode-cn.com/problems/power-of-two/solution/2de-mi-by-leetcode-solution-rny3/
 */
public class Qlc231 {

    public static boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }

        String binaryString = Integer.toBinaryString(n);
        int count = 0;
        for (int i = 0; i < binaryString.length(); i++) {
            char item = binaryString.charAt(i);

            if (item == 49) {
                count++;
            }
        }
        if (count == 1) {
            return true;
        } else {
            return false;
        }
    }


    public static boolean isPowerOfTwoV2(int n) {
        int i = n & (n - 1);
        if (i == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        boolean flag = isPowerOfTwoV2(4);

        System.out.println(flag);
    }
}
