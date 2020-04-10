package indi.pentiumcm.nowcoder.bytedance;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.nowcoder
 * @className: Byte_19_1
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2020/4/2 21:17
 * @describe: 万万没想到之聪明的编辑
 */
public class Byte_19_1 {

    /**
     * 检查 AAA 类型,去掉一个A
     *
     * @param s
     * @return
     */
    public List<Character> checkAAA(List<Character> s) {

        int len = s.size();

        if (len <= 2) {
            return s;
        }
        for (int i = 0; i < s.size() - 2; i++) {
            if (s.get(i).equals(s.get(i + 1)) && s.get(i).equals(s.get(i + 2))) {
                s.remove(i);
                i = i - 1;
            }
        }
        return s;
    }

    /**
     * 检查 AABB 类型,去掉一个B
     *
     * @param s
     * @return
     */
    public List<Character> checkAABB(List<Character> s) {
        if (s.size() <= 3) {
            return s;
        }

        for (int i = 0; i < s.size() - 3; i++) {
            if (s.get(i).equals(s.get(i + 1)) && s.get(i + 2).equals(s.get(i + 3))) {
                s.remove(i + 2);
            }
        }
        return s;
    }


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

//      吸收回车键
        in.nextLine();

        for (int i = 0; i < N; i++) {

            String s = in.nextLine();

            List<Character> src = new ArrayList<>(s.length());
            for (int j = 0; j < s.length(); j++) {
                src.add(s.charAt(j));
            }

            src = new Byte_19_1().checkAAA(src);
            src = new Byte_19_1().checkAABB(src);

            StringBuffer stringBuffer = new StringBuffer();
            for (int j = 0; j < src.size(); j++) {
                stringBuffer.append(src.get(j));
            }

            System.out.println(stringBuffer);
        }

    }
}
