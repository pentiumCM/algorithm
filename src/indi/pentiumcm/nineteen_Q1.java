package indi.pentiumcm;

import java.util.*;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm
 * @className: Q1_nine
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2020/3/15 10:52
 * @describe:
 */
public class nineteen_Q1 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();    //消除遗留的Enter符
        for (int i = 1; i <= num; i++) {
            String s = sc.nextLine();
            if (s.length() <= 2) {
                System.out.println(s);
            }
            StringBuilder sb = new StringBuilder();
            int flag = 0;
            char[] cArr = s.toCharArray();
            if (cArr[0] == cArr[1]) {
                flag = 2;
            }
            sb.append(cArr[0]).append(cArr[1]);
            for (int j = 2; j < cArr.length; j++) {
                if (flag == 0) {
                    sb.append(cArr[j]);
                    if (sb.charAt(sb.length() - 1) == sb.charAt(sb.length() - 2)) {
                        flag = 2;
                    }
                } else {
                    if (cArr[j] != sb.charAt(sb.length() - 1)) {
                        sb.append(cArr[j]);
                        flag--;
                    }
                }
            }
            System.out.println(sb.toString());
        }
    }
}