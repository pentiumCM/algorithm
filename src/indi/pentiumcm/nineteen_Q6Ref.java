package indi.pentiumcm;

import java.util.Scanner;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm
 * @className: nineteen_Q6Ref
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2020/3/15 17:44
 * @describe: 贪心算法实现
 */
public class nineteen_Q6Ref {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
//      价值为 N 的商品
        int N = in.nextInt();
//      找零
        int cash = 1024 - N;

        int num64 = cash / 64;
        int num16 = (cash - 64 * num64) / 16;
        int num4 = (cash - 64 * num64 - 16 * num16) / 4;
        int num1 = cash - 64 * num64 - 16 * num16 - 4 * num4;

        System.out.println(num1 + num4 + num16 + num64);
    }

}
