package indi.pentiumcm.leetcode;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.leetcode
 * @className: Q50
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2021/4/30 13:35
 * @describe: 剑指 Offer 58 - II. 左旋转字符串 —— 简单
 */
public class Q50 {

    public static String reverseLeftWords(String s, int n) {
        StringBuffer sb = new StringBuffer(s.length());

        for (int i = n; i < s.length(); i++) {
            sb.append(s.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        String s = "abcdefg";
        int k = 2;

        String s1 = reverseLeftWords(s, k);
        System.out.println(s1);
    }
}
