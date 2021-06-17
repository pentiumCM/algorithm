package indi.pentiumcm.leetcode;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.leetcode
 * @className: Q01
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2021/5/15 22:26
 * @describe: LCP 01. 猜数字
 */
public class Q01 {

    public int game(int[] guess, int[] answer) {
        int ans = 0;

        for (int i = 0; i < guess.length; i++) {
            int a = guess[i];
            int b = answer[i];

            if (a == b) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
