package indi.pentiumcm.leetcode;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.leetcode
 * @className: Q56
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2021/5/7 11:13
 * @describe: 1486. 数组异或操作
 */
public class Q56 {

    public static int xorOperation(int n, int start) {
        int ans = 0;

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = start + 2 * i;
        }

        for (int i = 0; i < n; i++) {
            ans ^= nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {

        int xorOperation = xorOperation(5, 0);

        System.out.println(xorOperation);
    }
}
