package indi.pentiumcm.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.leetcode
 * @className: Q41
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2021/3/16 11:07
 * @describe: leetcode —— 面试题 17.10. 主要元素
 */
public class Q41 {

    public int majorityElement(int[] nums) {
        int len = nums.length;
        int halfLen = len / 2 + 1;

        Map<Integer, Integer> ansMap = new HashMap<>();

        for (int i = 0; i < len; i++) {
            Integer orDefault = ansMap.getOrDefault(nums[i], 0);
            Integer count = orDefault + 1;
            ansMap.put(nums[i], count);
        }

        int ans = -1;
        Set<Integer> keys = ansMap.keySet();
        for (Integer item : keys) {
            Integer integer = ansMap.get(item);
            if (integer >= halfLen) {
                ans = item;
                break;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] att = {1, 2, 5, 9, 5, 9, 5, 5, 5};

        new Q41().majorityElement(att);

    }
}
