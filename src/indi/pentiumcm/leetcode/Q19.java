package indi.pentiumcm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.leetcode
 * @className: Q19
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2020/4/4 11:17
 * @describe: LeetCode-784. 字母大小写全排列
 */
public class Q19 {

    public void dfs(char[] temp, String S, int start, List<String> res) {
        int len = S.length();
//      递归的终止条件
//      遍历到字符串的结尾，直接退出
        if (start == len) {
            res.add(new String(temp));
            return;
        }
        temp[start] = S.charAt(start);
        dfs(temp, S, start + 1, res);

//      当遍历到的位置为字符，遍历另一个分支
        if (Character.isLetter(S.charAt(start))) {
            char ant = (char) (S.charAt(start) ^ 32);
            temp[start] = ant;

            dfs(temp, S, start + 1, res);
        }
    }

    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();

        int len = S.length();
        if (len == 0) {
            return res;
        }
        char[] temp = new char[S.length()];
        dfs(temp, S, 0, res);
        return res;
    }


    public static void main(String[] args) {
        List<String> res = new Q19().letterCasePermutation("a1b2");
    }
}
