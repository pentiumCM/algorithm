package indi.pentiumcm.leetcode;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.leetcode
 * @className: Q43
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2021/4/17 21:44
 * @describe: 存在重复元素 III
 */
public class Q43 {


    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((i + k) >= j) {
                    long absVal = (long) nums[i] - (long) nums[j];
                    long abs = Math.abs(absVal);
                    if (abs <= t) {
                        flag = true;
                        return flag;
                    }
                } else {
                    break;
                }
            }
        }
        return flag;
    }

    public static void main(String[] args) {

        int[] nums = {-2147483648, 2147483647};
        int k = 1, t = 1;


        boolean flag = containsNearbyAlmostDuplicate(nums, k, t);
        System.out.println(flag);
    }
}
