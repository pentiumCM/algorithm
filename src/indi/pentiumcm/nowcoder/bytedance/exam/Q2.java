package indi.pentiumcm.nowcoder.bytedance.exam;

import java.util.Scanner;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.nowcoder.test
 * @className: Q2
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2020/4/12 19:41
 * @describe: 折木棍的次数
 */
public class Q2 {

    /**
     * 求得操作的次数
     *
     * @param arr
     * @return
     */
    public int optConunt(int[] arr) {
        if (arr.length == 0 || arr.length == 1) {
            return 0;
        }

        int count = 0;
        int len = arr.length;
        for (int i = 1; i < len - 1; i++) {
            if (arr[i] > arr[i + 1]) {

                int div = arr[i];
                int cs = arr[i + 1];
                int bs = div / cs;
                count += bs;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

//      n个木棍
        int n = in.nextInt();

        int[] gz = new int[n];
        for (int i = 0; i < n; i++) {
            gz[i] = in.nextInt();
        }

        Q2 q2 = new Q2();
        int count = q2.optConunt(gz);

        System.out.print(count);
    }
}
