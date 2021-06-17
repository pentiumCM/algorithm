package indi.pentiumcm.exam.xiechen;

import java.util.Scanner;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.exam.xiechen
 * @className: Q25_2019
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2021/3/17 21:03
 * @describe: 输入一个long类型的数值, 求该数值的二进制表示中的1的个数
 */
public class Q25_2019 {

    public static int oneNums(long src) {

        int count = 0;

        while (src != 0) {
            count++;
            src = src & (src - 1);
        }
        return count;
    }


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        long src = in.nextLong();
        int nums = oneNums(src);
        System.out.println(nums);
    }
}
