package indi.pentiumcm.leetcode;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.leetcode
 * @className: Q18
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2020/4/2 17:35
 * @describe: LeetCode-392. 判断子序列
 */
public class Q18 {

    /**
     * 判断子序列
     *
     * @param s 子序列
     * @param t 长序列
     * @return
     */
    public boolean isSubsequence(String s, String t) {

        boolean flag = true;

        if (s.length() == 0) {
            flag = true;
        }

        int postIndex = 0;

        int lenTarget = s.length();
        int srcTarget = t.length();

        for (int i = 0; i < lenTarget; i++) {
            char target = s.charAt(i);

            flag = false;

            for (int j = postIndex; j < srcTarget; j++) {
                if (t.charAt(j) == target) {
                    flag = true;
                    postIndex = j + 1;
                    break;
                }
            }
            if (!flag) {
                return false;
            }
        }
        return flag;
    }


    public static void main(String[] args) {
        String s = "", t = "ahbgdc";
        boolean flag = new Q18().isSubsequence(s, t);
    }
}
