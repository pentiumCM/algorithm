package indi.pentiumcm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.leetcode
 * @className: Q24
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2020/5/25 20:58
 * @describe: leetcode 9. 回文数
 */
public class Q24 {

    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        else {
            List<Integer> nums = new ArrayList<>();
            // 获取末尾
            int index = x % 10;
            int div = x / 10;

            nums.add(index);
            while (div > 0) {

                index = div % 10;
                div = div / 10;

                nums.add(index);
            }

            int size = nums.size();

            int mid = (int) Math.floor((size + 1) * 1.0 / 2);

            for (int i = 0; i < mid; i++) {

                if (!nums.get(i).equals(nums.get(size - i - 1))) {
                    return false;
                }
            }
        }
        return true;
    }


    /**
     * 判断 X 是否为回文数
     * 反转一半数字
     *
     * @param x
     * @return
     */
    public boolean isPalindromeV2(int x) {
        if (x < 0)
            return false;
        else {
            List<Integer> nums = new ArrayList<>();
            // 获取末尾
            int index = x % 10;
            int div = x / 10;

            nums.add(index);
            while (div > 0) {

                index = div % 10;
                div = div / 10;

                nums.add(index);
            }

            int size = nums.size();

            int mid = (int) Math.floor((size + 1) * 1.0 / 2);

            for (int i = 0; i < mid; i++) {

                if (!nums.get(i).equals(nums.get(size - i - 1))) {
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Q24 q24 = new Q24();

        boolean palindrome = q24.isPalindrome(12321);

        System.out.println(palindrome);

    }

}
