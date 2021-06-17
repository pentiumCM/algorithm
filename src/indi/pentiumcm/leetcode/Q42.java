package indi.pentiumcm.leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.leetcode
 * @className: Q42
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2021/3/16 12:47
 * @describe: leetcode —— 977. 有序数组的平方
 */
public class Q42 {


    public int[] sortedSquares(int[] nums) {

        int len = nums.length;
        int[] res = new int[len];

        for (int i = 0; i < len; i++) {
            res[i] = (int) Math.pow(nums[i], 2);
        }

        Arrays.sort(res);
        return res;
    }

    public static void main(String[] args) {

        int[] arr = {-4, -1, 0, 3, 10};

        new Q42().sortedSquares(arr);
    }
}
