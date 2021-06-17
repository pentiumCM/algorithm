package indi.pentiumcm.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.exam
 * @className: Main1
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2021/5/27 18:54
 * @describe:
 */
public class Main1 {


    static int ans = 0;

    /**
     * 计算路线个数
     *
     * @param n      n个车站
     * @param router 路线矩阵
     * @param k      中转站个数
     * @param start  起点车站
     * @param stop   终点车站
     * @return
     */
    public static int countRouter(int n, int[][] router, int k, int start, int stop) {


        // 存放每一个解的结果
        Stack<Integer> path = new Stack<>();

        path.push(start);
        dfs(0, n, router, k, start, stop, path);

        return ans;
    }


    /**
     * 深度优先遍历
     *
     * @param curIndex 当前遍历的位置
     * @param n        n个车站
     * @param router   路线矩阵
     * @param k        中转站个数
     * @param start    起点车站
     * @param stop     终点车站
     * @return
     */
    public static void dfs(int curIndex, int n, int[][] router, int k, int start, int stop, Stack<Integer> path) {

        // 叶子节点
        if (path.peek() == stop) {
            ans++;
            return;
        }

        // 方案数
        for (int i = 1; i <= n; i++) {
            if (path.size() <= 2 + k) {
                if (!path.contains((Object) i)) {
                    // 取出栈顶元素
                    int pre = path.peek();
                    // 有路径
                    if (router[pre - 1][i - 1] == 1) {
                        path.add(i);
                        curIndex++;
                        dfs(curIndex, n, router, k, start, stop, path);

                        // 回溯
                        curIndex--;
                        path.pop();
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // n
        int n = Integer.parseInt(in.nextLine());
        // 线路
        String xl = in.nextLine();
        // x y
        String xy = in.nextLine();
        // k
        int k = in.nextInt();


        // 解析输入
        // x y
        int x = Integer.parseInt(xy.split(" ")[0]);
        int y = Integer.parseInt(xy.split(" ")[1]);

        String[] rout = xl.split(" ");

        int[][] router = new int[n][n];
        for (int i = 0; i < rout.length; i++) {
            String item = rout[i];
            Integer s0 = Integer.parseInt(item.split(",")[0]);
            Integer s1 = Integer.parseInt(item.split(",")[1]);

            router[s0 - 1][s1 - 1] = 1;
        }

        int countRouter = countRouter(n, router, k, 1, 3);

        System.out.println(countRouter);
    }
}
