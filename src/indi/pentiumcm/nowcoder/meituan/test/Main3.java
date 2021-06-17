package indi.pentiumcm.nowcoder.meituan.test;

import java.util.Scanner;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.nowcoder.meituan.indi.pentiumcm.subject.linkedlist.test
 * @className: Main3
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2021/3/20 15:56
 * @describe:
 */
public class Main3 {

    public static int mainfunc(int n, int m, int C, int[] A) {
        int res = 0;
        for (int i = 1; i <= m; i++) {
            res = Math.max(func(n, i, C, A), res);

        }
        return res;
    }

    public static int func(int n, int m, int C, int[] A) {
        int sum = 0;
        for (int i : A) {
            sum += i;
        }


        double res = 0.0;

        int avg = (int) Math.ceil(sum / m);
        boolean flag = false;
        for (int i = 0; i < A.length; i++) {

            int s = 0;
            flag = false;
            int j = i;

            for (; j < A.length; j++) {
                if ((s + A[j]) <= avg) {
                    s += A[j];
                } else {
                    flag = true;
                    break;
                }
            }
            i = j;
            if (flag) {
                res = Math.max(res, s / C);
            }
        }
        return (int) Math.ceil(res);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int c = sc.nextInt();

        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }

        System.out.println(mainfunc(n, m, c, A));
    }
}
