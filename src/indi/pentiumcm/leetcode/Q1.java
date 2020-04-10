package indi.pentiumcm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.leetcode
 * @className: Q1
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2020/3/16 9:48
 * @describe: 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 */
public class Q1 {


    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }


    public int[] twoSum(int[] nums, int target) {

        int[] result = new int[2];
//      设置两个指针，暴力解法
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Q1 a = new Q1();
        int[] arr = {5, 4, 2, 3, 1, 7, 8, 6, 9};
        int[] result = a.twoSum2(arr, 7);


    }
}
