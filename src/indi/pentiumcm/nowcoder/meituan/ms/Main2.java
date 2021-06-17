package indi.pentiumcm.nowcoder.meituan.ms;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.nowcoder.meituan.ms
 * @className: Main2
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2021/3/26 9:17
 * @describe: 全排列问题
 */
public class Main2 {


    /**
     * @param curIndex 当前遍历到哪一位
     * @param n        一共多少位
     * @param path     当前解
     * @param res      全部解
     */
    public static void dfs(int curIndex, int n, Stack<Integer> path, List<Integer[]> res) {
        // 前 n 位都排列好
        if (curIndex > n) {
            // 输出解
            int len = path.size();
            Integer[] resArr = new Integer[len];
            for (int i = 0; i < len; i++) {
                resArr[i] = path.get(i);
            }
            res.add(resArr);
            return;
        }

        // 方案数，i - 第 x 位用的是哪一个数
        for (int i = 1; i <= n; i++) {
            if (!path.contains(i)) {

                // 第 x 位选择元素 i
                path.push(i);

                dfs(curIndex + 1, n, path, res);

                // 回溯
                path.pop();
            }
        }
    }


    public static void main(String[] args) {
        int n = 3;

        // 保存最终的求解结果
        List<Integer[]> res = new ArrayList<>();

        // 过程中暂存某一个解的结果
        Stack<Integer> path = new Stack();

        dfs(1, n, path, res);

        System.out.println("");
    }

}

