package indi.pentiumcm.leetcode;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.leetcode
 * @className: Q421
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2021/5/16 20:43
 * @describe: 421. 数组中两个数的最大异或值
 */
public class Q421 {

    public static int findMaximumXOR(int[] nums) {
        int[] cns = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                int xor = nums[i] ^ nums[j];
                if (xor > cns[i]) {
                    cns[i] = xor;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < cns.length; i++) {
            if (ans < cns[i]) {
                ans = cns[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {3, 10, 5, 25, 2, 8};

        final int maximumXOR = findMaximumXOR(arr);

        System.out.println(maximumXOR);
    }
}
