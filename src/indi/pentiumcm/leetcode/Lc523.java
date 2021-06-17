package indi.pentiumcm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.leetcode
 * @className: Lc523
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2021/6/2 9:20
 * @describe: leetcode —— 523. 连续的子数组和
 */
public class Lc523 {

    public static boolean checkSubarraySum(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            int cnt = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                cnt += nums[j];

                if (cnt % k == 0) {
                    return true;
                }
            }
        }
        return false;
    }


    public static boolean checkSubarraySumV2(int[] nums, int k) {
        if (nums.length < 2) {
            return false;
        }

        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] += prefix[i - 1] + nums[i];
        }

        int[] div = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            div[i] = prefix[i] % k;
        }

        Map<Integer, Integer> divMap = new HashMap<>(nums.length);
        divMap.put(0, -1);
        for (int i = 0; i < div.length; i++) {

            if (divMap.containsKey(div[i])) {
                int preIndex = divMap.get(div[i]);
                if (i - preIndex >= 2) {
                    return true;
                }
            } else {
                divMap.put(div[i], i);
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[] nums = {23, 2, 4, 6, 6};
        int k = 7;

        boolean flag = checkSubarraySumV2(nums, k);
        System.out.println(flag);
    }

}
