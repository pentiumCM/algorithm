package indi.pentiumcm.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.leetcode
 * @className: Q53
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2021/5/6 0:18
 * @describe: 1512. 好数对的数目
 */
public class Q53 {

    public static int numIdenticalPairs(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>(nums.length);

        for (int i = 0; i < nums.length; i++) {

            Integer item = nums[i];
            Integer mapOrDefault = map.getOrDefault(item, 0);

            mapOrDefault++;
            map.put(item, mapOrDefault);
        }

        int ans = 0;
        Set<Integer> keySet = map.keySet();
        for (Integer item : keySet) {
            Integer val = map.get(item);
            ans += cnm(val, 2);
        }

        return ans;
    }


    /**
     * 排列组合，Cnm
     *
     * @param n
     * @param m
     * @return
     */
    public static int cnm(int n, int m) {
        int ans = 0;

        int bcs = 1;
        int cs = 1;
        for (int i = 1; i <= m; i++) {
            cs *= i;
            bcs *= (n + 1 - i);
        }
        ans = bcs / cs;
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 1, 3};

        int numIdenticalPairs = numIdenticalPairs(arr);
        System.out.println(numIdenticalPairs);
    }
}
