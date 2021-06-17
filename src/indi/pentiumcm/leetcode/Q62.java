package indi.pentiumcm.leetcode;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.leetcode
 * @className: Q62
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2021/5/15 9:12
 * @describe:
 */
public class Q62 {

    public int arraySign(int[] nums) {
        int ans = 0;

        int num_f = 0;

        for (Integer item : nums) {
            if (item == 0) {
                return 0;
            } else if (item < 0) {
                num_f++;
            }
        }

        if (num_f % 2 == 0) {
            return 1;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] nums = {-1, -2, -3, -4, 3, 2, 1};

        Q62 q62 = new Q62();
        q62.arraySign(nums);
    }
}
