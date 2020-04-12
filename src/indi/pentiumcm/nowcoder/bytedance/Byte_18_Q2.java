package indi.pentiumcm.nowcoder.bytedance;

import java.util.*;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm
 * @className: Q2
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2020/3/12 11:21
 * @describe: 字节跳动 - 2018后端2面 -Q1
 */
public class Byte_18_Q2 {


    //  判断颜色分布是否符合要求
    public static int isOK(List<Integer> positions, int m) {
        int unOk = 0;

        for (int i = 0; i < positions.size(); i++) {
            if (i != positions.size() - 1 && positions.get(i + 1) - positions.get(i) <= m - 1) {
                unOk++;
                break;
            } else if (i == positions.size() - 1 && positions.get(positions.size() - 1) - positions.get(0) <= m - 1) {
                unOk++;
            }
        }
        return unOk;
    }


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

//      串珠个数 5
        int n = in.nextInt();

//      区间长度 2
        int m = in.nextInt();

//      颜色种类 3
        int c = in.nextInt();

        Map<Integer, List<Integer>> colorMap = new HashMap<>();

//      遍历每一个球的颜色，将颜色作为 key，包含这种颜色的位置作为 value
        for (int i = 0; i < n; i++) {
//          每一种球颜色的个数
            int ballColNum = in.nextInt();
            for (int j = 0; j < ballColNum; j++) {
                int ballCol = in.nextInt();
//              如果颜色集合里面不含这种颜色，则添加 key 和value
                if (!colorMap.containsKey(ballCol)) {
                    List<Integer> color = new ArrayList<>();
                    color.add(i + 1);
                    colorMap.put(ballCol, color);
                } else {
                    List<Integer> color = colorMap.get(ballCol);
                    color.add(i + 1);
                }
            }
        }

        int count = 0;
//      遍历每一种颜色，看是否相邻
        for (int i = 0; i < c; i++) {
            int flag = isOK(colorMap.get(i + 1), m);
            count = count + flag;
        }

        System.out.println(count);
    }
}
