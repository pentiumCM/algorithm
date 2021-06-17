package indi.pentiumcm.leetcode;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.leetcode
 * @className: Q461
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2021/5/27 8:58
 * @describe:
 */
public class Q461 {

    public static int hammingDistance(int x, int y) {
        int i = x ^ y;
        String i2 = Integer.toBinaryString(i);

        int count = 0;
        for (int j = 0; j < i2.length(); j++) {
            int item = i2.charAt(j);
            if (item == 49) {
                count++;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        int x = 4;
        int y = 1;

        int ans = hammingDistance(x, y);

        System.out.println(ans);
    }
}
