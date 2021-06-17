package indi.pentiumcm.tags.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Double.POSITIVE_INFINITY;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.thought
 * @className: DpTSP
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2020/3/28 22:05
 * @describe: 动态规划 - 旅行商问题
 */
public class DpTSP {

    // 无穷大
    static int max = (int) POSITIVE_INFINITY / 2;

    /**
     * 旅行商问题算法实现
     *
     * @param distances 各个顶点之间距离的邻接矩阵的二维数组
     */
    public void tsp(int[][] distances) {
        int cityNum = distances.length;

        int colNum = 1 << cityNum - 1;
//      1. 构建动态规划dp表
        int[][] dp = new int[cityNum][colNum];

//      2. 确定一些初始状态：初始化dp表的第一列，即d(i,{∅}) = Ci0
        for (int i = 0; i < cityNum; i++) {
//          每个城市回到起点的距离
            dp[i][0] = distances[i][0];
        }

//      3. 确定状态转移方程，d[i][j]：i - 城市，j - {1,2,3,4}等
        for (int j = 1; j < colNum; j++) {

            for (int i = 0; i < cityNum; i++) {
                dp[i][j] = max;
//              {j}中的顶点包含起点i ，就continue
                if (((j >> (i - 1)) & 1) == 1) {
                    continue;
                }

//              遍历{ }里面的点集
                for (int k = 1; k < cityNum; k++) {
//                  排除{V}中不包含的顶点，如j = 5（二进制101）时，{}为{1，3}，这时候并不含有2，4，需要排除掉，直接continue
                    if (((j >> (k - 1)) & 1) == 0) {
                        continue;
                    }
//                  从i出发到 k,然后从k出发经过{V-k}
                    if (dp[i][j] > distances[i][k] + dp[k][j ^ (1 << (k - 1))]) {
                        dp[i][j] = distances[i][k] + dp[k][j ^ (1 << (k - 1))];
                    }
                }
            }
        }


        int minDistance = dp[0][colNum - 1];

//      回溯，求最短路径的流行
        List<Integer> path = new ArrayList<>();

//      存放剩余未走的城市顶点，key-value：皆为城市顶点标号
        Map<Integer, Integer> remPath = new HashMap<>();
        for (int i = 1; i < cityNum; i++) {
            remPath.put(i, i);
        }

//      将起点先存入列表
        path.add(0);
        int choseCity = 0;

        for (int j = cityNum - 1; j > 0; j--) {

            int col2 = 0;
            for (Integer cityIndex : remPath.keySet()) {
                col2 += 1 << remPath.get(cityIndex) - 1;
            }

            for (int i = 1; i < cityNum; i++) {

                choseCity = path.get(path.size() - 1);
                int cDis = distances[choseCity][i];

                if (dp[i][col2 ^ (1 << (i - 1))] + cDis == minDistance) {
                    path.add(i);

                    remPath.remove(i);
                    minDistance -= cDis;
                    break;
                }
            }
        }
        path.add(0);

        System.out.print("选择的最佳路径为：");
        for (int i = 0; i < path.size(); i++) {
            System.out.print(" " + path.get(i));
        }

        System.out.print("\n" + "最佳路径长度为：" + dp[0][colNum - 1]);
    }

    public static void main(String[] args) {

//      各个城市之间的距离的邻接矩阵
        int[][] distances = {
                {max, 3, max, 8, 9},
                {3, max, 3, 10, 5},
                {max, 3, max, 4, 3},
                {8, 10, 4, max, 20},
                {9, 5, 3, 20, max}
        };

        new DpTSP().tsp(distances);
    }
}
