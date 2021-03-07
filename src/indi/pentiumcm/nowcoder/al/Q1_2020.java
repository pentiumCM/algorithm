package indi.pentiumcm.nowcoder.al;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.nowcoder.al
 * @className: Q1
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2021/3/6 16:22
 * @describe: 给定一个序列A与一个序列B，每次只能把序列A的一个字符移动到字符尾，问能否通过这种方式把序列A变为序列B，
 * 如果能变成，最少需要多少次，输出最少次数N，不能变成输出-1。
 */
public class Q1_2020 {


    public int transfer(String a, String b) {
        boolean flag = false;

        if (a == null || b == null) {
            return -1;
        }
        if (a.length() != b.length()) {
            return -1;
        }

        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();

        int count = 0;
        for (int i = 0; i < bChars.length; i++) {
            char bChar = bChars[i];

            boolean isContain = Arrays.asList(aChars).contains(bChar);

            if (!isContain) {
                return -1;
            }

            for (int j = 0; j < aChars.length; j++) {
                char aChar = aChars[j];
                if (aChar == bChar) {

                }

            }


        }
        return -1;
    }

    public static void main(String[] args) {

//        String a = "bacfed";
//        String b = "abcdef";


        Scanner scanner = new Scanner(System.in);


        int a = 4;

        List<Integer> alist = new ArrayList<>();
        for (int i = 0; i < a; i++) {
            alist.add(scanner.nextInt());
        }


        for (Integer s : alist) {

            System.out.println("s：" + s);
        }

    }
}
