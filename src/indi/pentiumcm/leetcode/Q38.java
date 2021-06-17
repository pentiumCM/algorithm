package indi.pentiumcm.leetcode;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.leetcode
 * @className: Q38
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2021/3/13 22:25
 * @describe: leetcode —— 605. 种花问题
 */
public class Q38 {


    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length; i++) {
            // 如果已经种够花了，可以提前返回true
            if (n <= 0) {
                return true;
            }

            // 如果已经种过花了，则不能再种了
            if (flowerbed[i] == 1) {
                continue;
            }

            // 如果上一个格子已经种过花了，则当前这格不能种花
            if (i > 0 && flowerbed[i - 1] == 1) {
                continue;
            }

            // 如果下一个格子已经种过花了，则当前这格不能种花
            if (i < flowerbed.length - 1 && flowerbed[i + 1] == 1) {
                continue;
            }
            // 可以种花了，并且记录次数
            flowerbed[i] = 1;
            n--;
        }
        return n <= 0;

    }


    public static void main(String[] args) {
        int[] arr = {1, 0, 0, 0, 1};

        boolean f = new Q38().canPlaceFlowers(arr, 2);

        System.out.printf(f + "");
    }


}
