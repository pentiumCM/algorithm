package indi.pentiumcm.nowcoder.bytedance.exam;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.nowcoder.test
 * @className: Q3
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2020/4/12 20:09
 * @describe: 优惠券问题
 */
public class Q3 {


    /**
     * 总花费
     *
     * @param yhz
     * @param goods
     * @return
     */
    public int totalPri(int[] yhz, int[] goods) {
//      找出不大于g[i]的最大的yhz[j]

        int total = 0;

        int index = 0;
        for (int i = 0; i < goods.length; i++) {
            int price = goods[i];
            for (int j = index; j < yhz.length - 1; j++) {
                if (price == yhz[j + 1]) {
                    int temp = price - yhz[j];
                    total += temp;
                    index = j;
                    break;

                } else if (price >= yhz[j] && price < yhz[j + 1]) {
                    int temp = price - yhz[j];
                    total += temp;
                    index = j;
                    break;
                }
            }
        }
        return total;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

//      n个优惠券
        int n = in.nextInt();

//      m个商品
        int m = in.nextInt();

        int[] yhz = new int[n];
        for (int i = 0; i < n; i++) {
            yhz[i] = in.nextInt();
        }

        int[] goods = new int[m];
        for (int i = 0; i < m; i++) {
            goods[i] = in.nextInt();
        }

//      将优惠券和商品进行排序
        Arrays.sort(yhz);
        Arrays.sort(goods);

        Q3 q3 = new Q3();
        int total = q3.totalPri(yhz, goods);

        System.out.print(total);
    }
}
