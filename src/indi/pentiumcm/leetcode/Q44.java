package indi.pentiumcm.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.leetcode
 * @className: Q44
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2021/4/19 20:09
 * @describe:
 */
public class Q44 {

    public static int removeElement(int[] nums, int val) {

        int left = 0, right = 0;
        for (; right < nums.length; right++) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }


    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5, 6, 7, 12};
        int val = 5;


        removeElement(nums, val);

    }
}
