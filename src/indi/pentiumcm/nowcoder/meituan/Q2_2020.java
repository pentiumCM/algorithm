package indi.pentiumcm.nowcoder.meituan;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.nowcoder.meituan
 * @className: Q2_2020
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2021/3/20 10:57
 * @describe: 2021-10-2
 */
public class Q2_2020 {


    public static int countAct(int[] src) {
        int len = src.length;
        if (len == 0) {
            return 0;
        }
        Arrays.sort(src);

        int ans = 0;
        for (int i = 0; i < len; i++) {
            ans += Math.abs(i + 1 - src[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] src = new int[n];
        for (int i = 0; i < n; i++) {
            src[i] = in.nextInt();
        }

        int act = countAct(src);
        System.out.println(act);

    }
}
