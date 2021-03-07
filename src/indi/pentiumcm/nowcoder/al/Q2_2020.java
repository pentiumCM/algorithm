package indi.pentiumcm.nowcoder.al;

import java.util.Scanner;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.nowcoder.al
 * @className: Q2
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2021/3/6 16:46
 * @describe: 阿里2020 —— Q1
 */
public class Q2_2020 {


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }

        int count = 0;
        for (int i = 1; i < n - 1; i++) {
            int L = 0;
            int R = 0;
            for (int j = 0; j < i; j++) {
                if (L != 0 && a[j] > a[i]) {
                    L = Math.min(L, a[j]);
                    continue;
                }
                if (a[j] > a[i])
                    L = a[j];
            }

            for (int k = i + 1; k < n; k++) {
                if (a[k] < a[i]) {
                    R = Math.max(R, a[k]);
                }
            }

            if (L != 0 && R != 0 && L % R == 0) {
                count += 1;
            }
        }
        System.out.print(count);
    }

}

