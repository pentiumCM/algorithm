package indi.pentiumcm.nowcoder.bytedance;

import java.util.*;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.nowcoder.indi.pentiumcm.subject.linkedlist.test
 * @className: Q1
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2020/4/12 19:13
 * @describe: 数组a是否可以转化为数组b
 */
public class Q1 {


    /**
     * 判断 数组a是否可以变换成数组b
     *
     * @param a
     * @param b
     * @return
     */
    public boolean check(int[] a, int[] b) {
        if (a.length == 0 && b.length == 0) {
            return true;
        }
        if (a.length != b.length) {
            return false;
        }
        int len = a.length;
        int[] c = new int[len];

//      count0记录非0的个数
        int count0 = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < len; i++) {
            c[i] = b[i] - a[i];
            if (c[i] != 0) {
                count0++;
            }

            int count_key = map.getOrDefault(c[i], 0);
            if (count_key == 0) {
                map.put(c[i], i);
            }
        }

        if (count0 == 0 || count0 == 1) {
            return true;
        }

        Set<Integer> keySet = map.keySet();
        if (keySet.size() > 2) {
            return false;
        } else if (keySet.size() == 2) {
            List<Integer> keys = new ArrayList<>();
            for (Integer integer : keySet) {
                keys.add(map.get(integer));
            }
            if (Math.abs(keys.get(0) - keys.get(1)) != 1) {
                return false;
            }

        }
        return true;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

//      t组数据
        int t = in.nextInt();

        for (int i = 0; i < t; i++) {
//          每组数据的长度
            int n = in.nextInt();

            int[] a = new int[n];
            int[] b = new int[n];

            for (int j = 0; j < n; j++) {
                a[j] = in.nextInt();
            }
            for (int j = 0; j < n; j++) {
                b[j] = in.nextInt();
            }

            Q1 q1 = new Q1();

            boolean flag = q1.check(a, b);
            if (flag) {
                System.out.print("YES");
            } else {
                System.out.print("NO");
            }
        }
    }
}
