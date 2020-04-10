package indi.pentiumcm.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.leetcode
 * @className: Q5
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2020/3/19 10:37
 * @describe:
 */
public class Q5 {

    public int longestPalindrome(String s) {
        int hwNum = 0;
        int oddFlag = 0;

        int[] strArr = new int[128];
        for (Character c : s.toCharArray()) {
            strArr[c]++;
        }
        for (int count : strArr) {

            int rem = count % 2;

            count = rem == 0 ? count : count - 1;
            hwNum += count;

            if (rem == 1) {
                oddFlag = 1;
            }
        }

        hwNum = hwNum + oddFlag;
        return hwNum;
    }

    public static void main(String[] args) {
        String s = "abccccdd";
        int count = new Q5().longestPalindrome(s);
    }
}
