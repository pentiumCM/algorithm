package indi.pentiumcm.nowcoder.al;

import java.util.Scanner;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm
 * @className: Q1
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2021/3/6 19:09
 * @describe: 1，2，3种卡片放入 N*3 网格中，一共放入n行，求方案数
 */
public class Q1_2021 {

    /**
     * @param preRow:上一行的组合
     * @param rowIndex:当前行
     * @param colIndex:当前列
     * @param rowAll:总行数
     * @param temp:存储每行的中间结果
     * @param reCount:个数结果
     * @return
     */
    public static void dfs(int[] preRow, int rowIndex, int colIndex, int rowAll, int[] temp, int[] reCount) {
        // 解叶子：遍历到最后一行，最后一列
        if (rowIndex == rowAll && colIndex > 2) {
            // 结果+1
            reCount[0]++;
            return;
        }

        // 当前行遍历完毕
        if (rowIndex < rowAll && colIndex > 2) {
            // 遍历下一行

            // 记录当前行的结果
            for (int i = 0; i < 3; i++) {
                preRow[i] = temp[i];
            }
            rowIndex++;
            colIndex = 0;
        }

        // 对每一列进行遍历
        // 上一行的数据
        int pre = preRow[colIndex];
        // 获取当前行中某一列的左边值
        int colLeft = 0;
        if (colIndex > 0) {
            colLeft = temp[colIndex - 1];
        }

        // 方案数
        for (int i = 1; i < 4; i++) {
            // 当前值满足条件，遍历这一行的下一个值
            if (i != pre && i != colLeft) {
                temp[colIndex] = i;
                colIndex++;

                dfs(preRow, rowIndex, colIndex, rowAll, temp, reCount);

                // 回溯，将当前位置置0，重新对当前位置取值
                colIndex--;
                temp[colIndex] = 0;
            }
        }

    }

    public static int solutions(int row) {
        // 存储上一行的结果,默认是最上面一行的前一行为：[0,0,0]
        int[] preRow = {0, 0, 0};

        // 个数结果存储在 resCount
        int[] resCount = new int[1];

        // 存储每行的中间结果
        int[] temp = new int[3];

        // 从第一行第一列开始，进行深度搜索遍历
        dfs(preRow, 1, 0, row, temp, resCount);
        return resCount[0];
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // T组测试数据
        int T = sc.nextInt();
        int[] ts = new int[T];
        for (int i = 0; i < T; i++) {
            ts[i] = sc.nextInt();
        }

        for (int i = 0; i < ts.length; i++) {
            int res = solutions(ts[i]);
            int resFormat = (int) (res % Math.pow(10, 7));
            System.out.println(resFormat);
        }

    }
}
