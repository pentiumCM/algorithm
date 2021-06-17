package indi.pentiumcm.nowcoder.meituan;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.nowcoder.meituan
 * @className: Q1_2020
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2021/3/19 22:02
 * @describe: 2021 - 10-1
 */
public class Q1_2020 {


    public static int query(int[] src, int l, int r) {
        int len = src.length;
        if (len == 0) {
            return -1;
        }

        Arrays.sort(src);
        for (int i = 0; i < len; i++) {
            int llen = i + 1;
            int rlen = len - i - 1;

            if (llen >= l && r >= llen
                    && rlen >= l && r >= rlen) {
                return src[i];
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();

        int[] src = new int[n];
        for (int i = 0; i < n; i++) {
            src[i] = in.nextInt();
        }

        int ans = query(src, x, y);

        System.out.println(ans);
    }
}
