package indi.pentiumcm;

import java.util.Scanner;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm
 * @className: Q1
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2020/3/11 21:32
 * @describe: 字节跳动 - 2018后端2面 -Q1
 */
public class eighteen_Q1 {

    /**
     * 执行查询
     *
     * @param l         区间左端
     * @param r         区间右端
     * @param k         查询字段
     * @param userLikes 查询集合
     * @return
     */
    public static int exQuerys(int l, int r, int k, int[] userLikes) {
        int matchNum = 0;

        int beg = l - 1;
        int end = r - 1;

        for (int i = beg; i <= end; i++) {
            if (userLikes[i] == k) {
                matchNum++;
            }
        }
        return matchNum;
    }


    public static void main(String[] args) {

//      从键盘输入样例
        Scanner in = new Scanner(System.in);

        int userNum = in.nextInt();

        int[] userLikes = new int[userNum];
        for (int i = 0; i < userNum; i++) {
            userLikes[i] = in.nextInt();
        }

        int queryNum = in.nextInt();

        int[] result = new int[queryNum];
        for (int i = 0; i < queryNum; i++) {
            int l = in.nextInt();
            int r = in.nextInt();
            int k = in.nextInt();

            result[i] = exQuerys(l, r, k, userLikes);
        }


        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
