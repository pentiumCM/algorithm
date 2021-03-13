package indi.pentiumcm.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.leetcode
 * @className: Q32
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2021/3/10 11:34
 * @describe: 1415. 长度为 n 的开心字符串中字典序第 k 小的字符串
 */
public class Q32 {


    String[] items = {"a", "b", "c"};

    /**
     * 深度优先进行搜索
     *
     * @param currentIndex: 当前遍历到哪一位
     * @param n:            字符串总长度
     * @param path:         当前解
     * @param res:          全部解结果
     */
    public void dfs(int currentIndex, int n, Stack<String> path, List<List> res) {

        // 1. 解空间
        if (currentIndex > n) {
            List<String> tmps = new ArrayList<>();
            for (int i = 0; i < path.size(); i++) {
                tmps.add(path.get(i));
            }
            res.add(tmps);
            return;
        }

        // 获取前一个元素
        String preStr = "";
        if (path.size() > 0) {
            preStr = path.peek();
        }

        // 方案数
        for (String item : items) {
            if (!item.equals(preStr)) {
                path.push(item);
                currentIndex++;
                dfs(currentIndex, n, path, res);

                // 回溯
                currentIndex--;
                path.pop();
            }
        }
    }

    public String getHappyString(int n, int k) {
        // 存放结果
        List<List> res = new ArrayList<>();

        // 存放每一个解的结果
        Stack<String> path = new Stack<>();

        dfs(1, n, path, res);

        String resStr = "";
        if (res.size() > k - 1) {
            List<String> resStrings = res.get(k - 1);
            for (int i = 0; i < resStrings.size(); i++) {
                resStr += resStrings.get(i);
            }
        }
        return resStr;
    }


    public static void main(String[] args) {
        String str = new Q32().getHappyString(3, 9);

        System.out.printf(str);
    }
}
