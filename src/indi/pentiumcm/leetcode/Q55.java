package indi.pentiumcm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.leetcode
 * @className: Q55
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2021/5/6 12:59
 * @describe:
 */
public class Q55 {

    public static int[] shuffle(int[] nums, int n) {

        int[] ans = new int[nums.length];

        for (int i = 0; i < n; i++) {
            ans[i * 2] = nums[i];
        }
        for (int i = 0; i < n; i++) {
            ans[i * 2 + 1] = nums[n + i];
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 4, 3, 2, 1};
        int n = 4;

        int[] shuffle = shuffle(nums, n);
        System.out.println(shuffle);
    }
}
