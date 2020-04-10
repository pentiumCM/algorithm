package indi.pentiumcm.thought;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.thought
 * @className: Test
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2020/3/28 23:16
 * @describe:
 */
public class Test {

    public static void main(String[] args) {
        int cityCount = 4;
        int[][] roadInfo = new int[][]{
                {0, 1, 10},
                {1, 0, 10},
                {1, 3, 25},
                {3, 1, 25},
                {3, 2, 30},
                {2, 3, 30},
                {0, 2, 15},
                {2, 0, 15},
                {1, 2, 35},
                {2, 1, 35}
        };

        int roadmap[][] = new int[cityCount][cityCount];        //转成邻接矩阵方便取数
        int dp[][] = new int[cityCount][1 << (cityCount - 1)];
        String path[][] = new String[cityCount][1 << (cityCount - 1)];
        for (int i = 0; i < cityCount; i++) {
            for (int j = 0; j < cityCount; j++) {
                roadmap[i][j] = 0x7ffff;                        //用0x7ffff表示无穷大
            }
        }
        for (int i = 0; i < roadInfo.length; i++) {                 //邻接矩阵
            roadmap[roadInfo[i][0]][roadInfo[i][1]] = roadInfo[i][2];
        }

        for (int i = 0; i < cityCount; i++) {                          //先求dp表第一列
            dp[i][0] = roadmap[i][0];                            //求出了每个城市回到起点的距离了。
//            path[i][j] = i;                                        //记录初始路径。
        }

        for (int j = 1; j < 1 << (cityCount - 1); j++) {             //再求其他列
            for (int i = 0; i < cityCount; i++) {                    //从i出发，要去包含j = {010101}的    城市
                dp[i][j] = 0x7ffff;
                if (((j >> (i - 1)) & 1) == 1) {                   //如果已经到过j了，就continue
                    continue;
                }
                for (int k = 1; k < cityCount; k++) {                 //看能不能先到k城市
                    if (((j >> (k - 1)) & 1) == 0) {
                        continue;                                 //不能先到k城市，continue;
                    }
                    if (dp[i][j] > roadmap[i][k] + dp[k][j ^ (1 << (k - 1))]) {
                        dp[i][j] = roadmap[i][k] + dp[k][j ^ (1 << (k - 1))];
                        path[i][j] = i + path[k][j ^ (1 << (k - 1))]; //找到更短路径，覆盖之前结果。
                    }
                }
            }
        }
        System.out.println(dp[0][(1 << (cityCount - 1)) - 1]);
        System.out.println(path[0][(1 << (cityCount - 1)) - 1]);
    }
}
