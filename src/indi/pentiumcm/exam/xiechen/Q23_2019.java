package indi.pentiumcm.exam.xiechen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.exam.xiechen
 * @className: Q23_2019
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2021/3/17 20:43
 * @describe: 查询满足区间的记录
 */
public class Q23_2019 {


    public static List<Integer> query(int target, int[][] src) {

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < src.length; i++) {
            int[] item = src[i];
            if (item[1] <= target && item[2] >= target) {
                ans.add(item[0]);
            }
        }

        Collections.sort(ans);
        return ans;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int num = in.nextInt();
        int target = in.nextInt();

        int[][] src = new int[num][3];

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < 3; j++) {
                src[i][j] = in.nextInt();
            }
        }

        List<Integer> query = query(target, src);
        if (query.size() == 0) {
            System.out.printf("null");
            return;
        }

        for (Integer item : query) {
            System.out.println(item + "");
        }

    }
}
