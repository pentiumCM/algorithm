package indi.pentiumcm.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.leetcode
 * @className: Q33
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2021/3/10 20:55
 * @describe:
 */
public class Q33 {

    // 方案
    public String[] x = {"(", ")"};


    public void dfs(int currentIndex, int nums, Stack<String> path, List<String> res) {

        if (currentIndex == nums) {
            String tmp = "";
            for (int i = 0; i < path.size(); i++) {
                tmp += path.get(i);
            }
            tmp += ")";
            res.add(tmp);
            return;
        }

        int count1 = 0;
        int count2 = 0;
        for (String s : path) {
            if ("(".equals(s)) {
                count1++;
            } else if (")".equals(s)) {
                count2++;
            }
        }

        // 方案选择
        // 从第二位开始选择
        for (String item : x) {

            // + ( 的条件
            if (count1 < nums / 2) {
                if ("(".equals(item)) {
                    path.push(item);

                    currentIndex++;
                    dfs(currentIndex, nums, path, res);

                    // 回溯
                    currentIndex--;
                    path.pop();
                }
            }

            // + ） 的条件
            if (count1 > count2 && count2 < nums / 2) {
                if (")".equals(item)) {
                    path.push(item);

                    currentIndex++;
                    dfs(currentIndex, nums, path, res);

                    // 回溯
                    currentIndex--;
                    path.pop();
                }
            }
        }

    }


    /**
     * 深度搜索 + 剪枝
     *
     * @param left  左括号个数
     * @param right 右括号个数
     * @param n     待匹配括号个数
     * @param path  当前结果
     * @param res   解空间
     */
    public void dfs_v2(int left, int right, int n, String path, List<String> res) {

        if (left == n && right == n) {
            res.add(path);
            return;
        }

        if (left < right) {
            return;
        }

        if (left < n) {
            dfs_v2(left + 1, right, n, path + "(", res);
        }

        if (right < n) {
            dfs_v2(left, right + 1, n, path + ")", res);
        }

    }


    public List<String> generateParenthesis(int n) {

        // V1
//        int num = n * 2;
//        List<String> res = new ArrayList<>();
//        Stack<String> path = new Stack<>();
//        path.push("(");
//
//        dfs(2, num, path, res);
//
//        return res;


        // v2
        List<String> res = new ArrayList<>();
        String path = "";
        dfs_v2(0, 0, n, path, res);

        return res;

    }


    public static void main(String[] args) {

        List<String> list = new Q33().generateParenthesis(2);

        System.out.printf("");
    }
}
