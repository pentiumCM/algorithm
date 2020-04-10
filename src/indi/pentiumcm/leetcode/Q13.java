package indi.pentiumcm.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.leetcode
 * @className: Q13
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2020/3/30 10:12
 * @describe: 面试题62. 圆圈中最后剩下的数字
 */
public class Q13 {

    public int lastRemaining(int n, int m) {

//      将 n 个是存入链表中，方便删除
        List<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

//      判断删除位置的索引
        int idx = 0;
        while (n > 1) {
            idx = (idx + m - 1) % n;
            list.remove(idx);
            n--;
        }
        return list.get(0);
    }


    public static void main(String[] args) {
        int res = new Q13().lastRemaining(5, 3);
    }


}
