package indi.pentiumcm.nowcoder.meituan;

import java.util.Scanner;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.nowcoder.meituan
 * @className: Q3
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2021/3/20 11:18
 * @describe: 2021-10-3
 */
public class Q3 {


    public static int[] query(String[] src) {

//        int N = src[0];

        // 餐桌用餐数
        String NItem = src[1];
        int[] NArr = new int[NItem.length()];
        for (int i = 0; i < NItem.length(); i++) {
            NArr[i] = NItem.charAt(i);
        }

//        int M = src[2];
        String res = src[3];
        int[] ans = new int[res.length()];


        boolean flag = false;
        boolean flag2 = false;
        for (int i = 0; i < res.length(); i++) {
            char sex = res.charAt(i);
            // 男性
            if (sex == 'M') {
                for (int j = 0; j < NArr.length; j++) {
                    // 有空位：1
                    if (NArr[j] == 49) {
                        NArr[j] += 1;
                        ans[i] = j + 1;

                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    flag = false;
                    continue;
                }
                for (int j = 0; j < NArr.length; j++) {
                    // 有空位：0
                    if (NArr[j] == 48) {
                        NArr[j] += 1;
                        ans[i] = j + 1;
                        break;
                    }
                }
            } else {
                for (int j = 0; j < NArr.length; j++) {
                    // 有空位：0
                    if (NArr[j] == 48) {
                        NArr[j] += 1;
                        ans[i] = j + 1;

                        flag2 = true;
                        break;
                    }
                    // 无空位
                }

                if (flag2) {
                    flag2 = false;
                    continue;
                }
                for (int j = 0; j < NArr.length; j++) {
                    // 有空位：1
                    if (NArr[j] == 49) {
                        NArr[j] += 1;
                        ans[i] = j + 1;
                        break;
                    }
                    // 无空位
                }
            }

        }

        return ans;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        // 数据组
        int T = in.nextInt();

        for (int i = 0; i < T; i++) {
            String[] src = new String[4];
            for (int j = 0; j < 4; j++) {
                src[j] = in.next();
            }

            int[] ans = query(src);

            for (int j = 0; j < ans.length; j++) {
                System.out.println(ans[j]);
            }
        }

    }

}
