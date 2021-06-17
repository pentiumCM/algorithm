package indi.pentiumcm.nowcoder.meituan.test;

import java.util.Scanner;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.nowcoder.meituan.indi.pentiumcm.subject.linkedlist.test
 * @className: Main4
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2021/3/20 15:57
 * @describe:
 */
public class Main4 {


    public static int query(int[][] src, int m) {

        int[] res = new int[m];

        // 取ai,j为 a0,1 —— 作为明天的值
        // 初始为：1，0，t2
        int t2 = src[0][1];
        res[0] = 0;
        res[1] = t2;
        for (int i = 2; i < m; i++) {

            int t0 = res[i - 2];
            int t1 = res[i - 1];

            res[i] = src[t1][t0];
        }

        return res[m - 1] - 1;

    }


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        int[][] items = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                items[i][j] = in.nextInt() - 1;
            }
        }

        int query = query(items, m);
        System.out.println(query);
    }
}
