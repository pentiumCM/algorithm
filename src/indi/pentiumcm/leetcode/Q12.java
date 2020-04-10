package indi.pentiumcm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.leetcode
 * @className: Q12
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2020/3/27 8:54
 * @describe: 914. 卡牌分组
 */
public class Q12 {

    public boolean hasGroupsSizeX(int[] deck) {
        int N = deck.length;
        int[] count = new int[10000];
        for (int c : deck) {
            count[c]++;
        }

        List<Integer> values = new ArrayList();
        for (int i = 0; i < 10000; ++i) {
            if (count[i] > 0) {
                values.add(count[i]);
            }
        }

        boolean flag;
        for (int X = 2; X <= N; ++X) {
            if (N % X == 0) {
                flag = true;
                for (int i = 0; i < values.size(); i++) {
                    int num = values.get(i);
                    if (num % X != 0) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {

        int[] a = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1};
        boolean flag = new Q12().hasGroupsSizeX(a);


    }
}
