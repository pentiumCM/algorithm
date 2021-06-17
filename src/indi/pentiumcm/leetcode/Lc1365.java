package indi.pentiumcm.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.leetcode
 * @className: Lc1365
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2021/6/1 9:18
 * @describe: leetcode —— 1365. 有多少小于当前数字的数字
 */
public class Lc1365 {

    public static int[] smallerNumbersThanCurrent(int[] nums) {

        int[] ans = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    count++;
                }
            }
            ans[i] = count;
        }
        return ans;
    }


    public static int[] smallerNumbersThanCurrentV2(int[] nums) {
        int n = nums.length;
        int[][] data = new int[n][2];
        for (int i = 0; i < n; i++) {
            data[i][0] = nums[i];
            data[i][1] = i;
        }
        Arrays.sort(data, new Comparator<int[]>() {
            @Override
            public int compare(int[] data1, int[] data2) {
                return data1[0] - data2[0];
            }
        });

        int[] ret = new int[n];
        int prev = -1;
        for (int i = 0; i < n; i++) {
            if (prev == -1 || data[i][0] != data[i - 1][0]) {
                prev = i;
            }
            ret[data[i][1]] = prev;
        }
        return ret;
    }


    public static void main(String[] args) {

        int[] nums = {8, 1, 2, 2, 3};

        int[] ans = smallerNumbersThanCurrentV2(nums);

        System.out.println();
    }
}
