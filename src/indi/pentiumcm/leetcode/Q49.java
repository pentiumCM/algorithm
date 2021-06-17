package indi.pentiumcm.leetcode;

import java.util.*;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.leetcode
 * @className: Q49
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2021/4/30 13:15
 * @describe: 137. 只出现一次的数字 II
 */
public class Q49 {

    public static int singleNumber(int[] nums) {
        int ans = 0;

        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int item = nums[i];
            Integer mapOrDefault = map.getOrDefault(item, 0);
            mapOrDefault++;
            map.put(item, mapOrDefault);
        }

        Set<Integer> keySet = map.keySet();
        for (Integer i : keySet) {
            Integer integer = map.get(i);
            if (integer == 1) {
                ans = i;
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 1, 0, 1, 99};
        int singleNumber = singleNumber(nums);

        System.out.println(singleNumber);
    }

}
