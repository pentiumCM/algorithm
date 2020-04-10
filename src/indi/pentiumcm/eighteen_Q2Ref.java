package indi.pentiumcm;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm
 * @className: Q2Ref
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2020/3/12 22:09
 * @describe:
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class eighteen_Q2Ref {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int c = scan.nextInt();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            int a = scan.nextInt();
            for (int j = 0; j < a; ++j) {
                int b = scan.nextInt();

                if (map.containsKey(b)) {
                    map.get(b).add(i + 1);
                } else {
                    List<Integer> list = new LinkedList<>();
                    list.add(i + 1);
                    map.put(b, list);
                }
            }
        }
        int sum = 0;

        for (int i = 0; i < c; ++i) {
            List<Integer> list = map.get(i + 1);
            for (int j = 0; j < list.size(); ++j) {
                if (j < list.size() - 1 && list.get(j + 1) - list.get(j) <= m - 1) {

                    ++sum;

                    break;
                }
                if (j == list.size() - 1) {
                    if (n - list.get(list.size() - 1) + list.get(0) <= m - 1) {
                        ++sum;


                    }
                }
            }

        }

        System.out.println(sum);

    }
}

