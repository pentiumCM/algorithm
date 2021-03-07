package indi.pentiumcm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.leetcode
 * @className: Q25
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2020/6/1 17:32
 * @describe: leetcode - 1431. 拥有最多糖果的孩子
 */
public class Q25 {

    /**
     * 判断分配给某孩子分分配是否能达到最大数
     *
     * @param candies
     * @param extraCandies
     * @return
     */
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = getMax(candies);


        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < candies.length; i++) {
            res.add(judge(max, candies[i], extraCandies));

        }
        return res;
    }


    /**
     * 获取数组中的最大元素
     *
     * @param arr
     * @return
     */
    public int getMax(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }


    /**
     * @param max
     * @param candie
     * @param extra
     * @return
     */
    public boolean judge(int max, int candie, int extra) {

        if (candie == max || candie + extra >= max) {
            return true;
        } else {
            return false;
        }
    }

}
