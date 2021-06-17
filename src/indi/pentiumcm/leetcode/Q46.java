package indi.pentiumcm.leetcode;

import com.sun.org.apache.regexp.internal.RE;

import java.util.*;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.leetcode
 * @className: Q46
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2021/4/26 20:51
 * @describe: 3. 无重复字符的最长子串
 */
public class Q46 {

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            int temp = 0;

            List<Character> itemlist = new ArrayList<>(s.length());
            for (int j = i; j < s.length(); j++) {
                char item = s.charAt(j);
                if (!itemlist.contains(item)) {
                    itemlist.add(item);
                    temp++;
                    if (temp > max) {
                        max = temp;
                    }
                } else {
                    if (temp > max) {
                        max = temp;
                    }
                    break;
                }
            }
        }
        return max;
    }


    public static int lengthOfLongestSubstring_v2(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }


    public static void main(String[] args) {

        String s = "abcabcbb";
        int ans = lengthOfLongestSubstring_v2(s);

        System.out.println(ans);

    }
}
