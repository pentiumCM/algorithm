package indi.pentiumcm.leetcode;


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.leetcode
 * @className: Q316
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2021/5/19 11:34
 * @describe:
 */
public class Q316 {

    public static String removeDuplicateLetters(String s) {
        List<Character> list = new ArrayList<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i));
        }

        List<Integer> rmIndex = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            char cur = list.get(i);
            boolean hasMin = false;
            for (int j = i + 1; j < s.length(); j++) {
                char next = s.charAt(j);
                if (next < cur) {
                    hasMin = true;
                } else if (next == cur) {
                    if (hasMin) {
                        rmIndex.add(i);
                        break;
                    } else {
                        rmIndex.add(j);
                        break;
                    }
                }
            }
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            if (!rmIndex.contains(i)) {
                sb.append(list.get(i));
            }
        }

        return sb.toString();
    }




    public static void main(String[] args) {

        String bcabca = removeDuplicateLetters("cbacdcbc");


        System.out.printf(bcabca);
    }

}
