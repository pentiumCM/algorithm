package indi.pentiumcm.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.leetcode
 * @className: Q34
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2021/3/11 15:58
 * @describe: leetcode —— 面试题 08.07. 无重复字符串的排列组合
 */
public class Q34 {

    void dfs(int curIndex, int n, List<Character> characters, Stack<Character> path, List<String> res) {
        if (curIndex > n) {
            String tmp = "";
            for (Character item : path) {
                tmp += item;
            }
            res.add(tmp);
            return;
        }

        for (Character item : characters) {
            if (!path.contains(item)) {
                path.push(item);
                curIndex++;
                dfs(curIndex, n, characters, path, res);

                // 回溯
                curIndex--;
                path.pop();
            }
        }
    }


    public String[] permutation(String S) {

        List<Character> characters = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            Character character = S.charAt(i);
            if (!characters.contains(character)) {
                characters.add(character);
            }
        }

        int n = characters.size();
        List<String> res = new ArrayList<>();
        Stack<Character> path = new Stack<>();

        dfs(1, n, characters, path, res);

        String[] ans = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }

        return ans;
    }


    public static void main(String[] args) {
        new Q34().permutation("qwe");
    }
}
