package indi.pentiumcm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.leetcode
 * @className: Q57
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2021/5/10 8:57
 * @describe: 1482. 制作 m 束花所需的最少天数
 */
public class Q57 {

    public static int minDays(int[] bloomDay, int m, int k) {
        int ans = 0;
        int count = 0;

        if (bloomDay.length < m * k) {
            return -1;
        }

        List<Integer> list = new ArrayList<>(bloomDay.length);
        for (Integer item : bloomDay) {
            list.add(item);
        }

        while (count < m) {
            // 记录每一次的最优解，邻域最大值中的最小
            int optMax = Integer.MAX_VALUE;
            int optIndex = 0;

            // 开始滑窗
            // 采用贪心算法：最优解为当前邻接域的最小值
            for (int i = 0; i < list.size() - k + 1; i++) {
                // 记录邻域的最大值
                int tempMax = 0;
                int tempIndex = 0;
                for (int j = i; j < i + k; j++) {
                    int temp = list.get(j);
                    if (temp > tempMax) {
                        tempMax = temp;
                    }
                }

                if (tempMax < optMax) {
                    optMax = tempMax;
                    optIndex = i;
                }
            }
            // 处理最优解
            count++;

            if (optMax > ans) {
                ans = optMax;
            }

            // 删除已有的花
            for (int i = optIndex; i < optIndex + k; i++) {
                list.remove(optIndex);
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        int[] bloomDay = {1, 10, 3, 10, 2};
        int m = 3, k = 1;


        int minDays = minDays(bloomDay, m, k);
        System.out.println(minDays);

    }
}
