package indi.pentiumcm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.leetcode
 * @className: Q45
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2021/4/19 20:38
 * @describe: leetcode —— 1. 两数之和
 */
public class Q45 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);

        for (int i = 0; i < nums.length; i++) {

            int other = target - nums[i];
            if (map.containsKey(other)) {
                return new int[]{map.get(other), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {

        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] ans = new Q45().twoSum(nums,target);

        System.out.println(ans);

    }
}
