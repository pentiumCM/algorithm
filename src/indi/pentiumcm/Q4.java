package indi.pentiumcm;

import java.util.Scanner;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm
 * @className: Q4
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2020/3/15 19:16
 * @describe: 第四题
 */
public class Q4 {

    /**
     * 判断操作是否合法
     *
     * @param opt 操作，对应两个点的坐标
     * @return
     */
    public static boolean isOK(int[] opt) {
        boolean flag = true;


        return flag;
    }


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
//      棋盘行
        int n = in.nextInt();
//      棋盘列
        int m = in.nextInt();

//      接收方块输入
        String[] points = new String[n];
        for (int i = 0; i < n; i++) {
            points[i] = in.next();
        }

//      接收用户操作
        int q = in.nextInt();
        int[][] opts = new int[q][4];
        for (int i = 0; i < q; i++) {
            for (int j = 0; j < 4; j++) {
                opts[i][j] = in.nextInt();
            }
        }


    }
}







