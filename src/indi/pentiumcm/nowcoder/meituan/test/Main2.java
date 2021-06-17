package indi.pentiumcm.nowcoder.meituan.test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.nowcoder.meituan.indi.pentiumcm.subject.linkedlist.test
 * @className: Main2
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2021/3/20 15:56
 * @describe:
 */
public class Main2 {


    /**
     * 判断集合 A 与 集合 B是否相同
     *
     * @param A
     * @param B
     * @return
     */
    public static boolean judge(int[] A, int[] B) {

        if (A.length != B.length) {
            return false;
        }

        int count = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {

                int src = A[i];
                int dst = B[j];
                if (src == dst) {
                    B[j] = -1;
                    count++;
                    break;
                }
            }
        }
        if (count == A.length) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * (A+x) mod m，求 x
     *
     * @param A
     * @param B
     * @param m
     * @return
     */
    public static int query(int[] A, int[] B, int m) {
        Arrays.sort(A);
        Arrays.sort(B);

        if (A.length != B.length) {
            return 0;
        }

        int len = A.length;
        for (int i = 1; i <= m; i++) {

            // (A+x) mod m
            int[] res = new int[len];
            for (int j = 0; j < len; j++) {
                res[j] = (A[j] + i) % m;
            }

            boolean judge = judge(B, res);

            if (judge) {
                return i;
            }
        }

        return 0;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        int[] A = new int[n];
        int[] B = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            B[i] = in.nextInt();
        }

        int query = query(A, B, m);

        System.out.println(query);
    }
}
