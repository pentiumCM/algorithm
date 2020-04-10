package indi.pentiumcm.thought;

import java.util.ArrayList;
import java.util.List;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.thought
 * @className: BtPerm
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2020/4/4 23:10
 * @describe: 回溯法 - 全排列问题
 */
public class BtPerm {

    public int[] vis = new int[100];

    /**
     * @param x    第 x 位进行搜索遍历
     * @param n    一共多少位
     * @param temp
     * @param res
     */
    void dfs(int x, int n, Integer[] temp, List<Integer[]> res) {
//      前 n 位都排列好
        if (x > n) {
//          输出解
            Integer[] resArr = new Integer[temp.length];
            for (int i = 0; i < x - 1; i++) {
                resArr[i] = temp[i];
                System.out.print(temp[i] + "  ");
            }
            System.out.print("\n");
            res.add(resArr);
            return;
        }

//      方案数，i - 第 x 位用的是哪一个数
        for (int i = 1; i <= n; i++) {
            if (vis[i] == 0) {

                vis[i] = 1;

//              第 x 位选择元素 i
                temp[x - 1] = i;

                dfs(x + 1, n, temp, res);

//              回溯
                vis[i] = 0;
            }
        }
    }


    public static void main(String[] args) {
        BtPerm btPerm = new BtPerm();

        int n = 10;
//      保存最终的求解结果
        List<Integer[]> res = new ArrayList<>();
//      过程中暂存某一个解的结果
        Integer[] temp = new Integer[n];

        btPerm.dfs(1, n, temp, res);
    }

}
