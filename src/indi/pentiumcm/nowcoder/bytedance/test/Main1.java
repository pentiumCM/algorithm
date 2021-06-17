package indi.pentiumcm.nowcoder.bytedance.test;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.nowcoder.bytedance.exam
 * @className: Main1
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2021/3/21 9:49
 * @describe:
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> src = new ArrayList<>();

        String inp = in.nextLine();
        String[] inpVals = inp.split(" ");
        for (int i = 0; i < inpVals.length; i++) {
            src.add(Integer.parseInt(inpVals[i]));
        }

        int sum1 = 0;
        int sum2 = 0;
        int ans = 0;
        for (int i = 0; i < src.size(); i++) {
            sum1 += src.get(i);
        }
        sum2 = sum1 * 2;

        boolean flag = false;
        for (int i = sum1; i <= sum2; i++) {
            flag = false;
            int total = i;
            ans = i;
            for (int j = 0; j < src.size(); j++) {
                int item = src.get(j);
                int min = Math.min(item * 2, total / 2);

                if (j < src.size() - 1) {

                }
                if (min >= item) {
                    total -= min;
                } else {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                continue;
            }
            System.out.println(ans);
            return;
        }

    }
}



