package indi.pentiumcm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm
 * @className: nine_Q4
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2020/3/15 14:38
 * @describe:
 */
public class nineteen_Q4 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        for (int i = 0; i < N; i++) {
            Map<String, Integer> map = new HashMap<>();
            Map<String, Integer> currMap = new HashMap<>();
            int M = in.nextInt();
            int max = 1;
            for (int j = 0; j < M; j++) {
                currMap.clear();
                int n = in.nextInt();
                //System.out.print("n" + n);
                for (int k = 0; k < n; k++) {
                    int x = in.nextInt();
                    int y = in.nextInt();
                    String key = String.valueOf(x) + "-" + String.valueOf(y);
                    //System.out.print(" "+key);
                    Integer value = map.getOrDefault(key, 0) + 1;
                    //System.out.print("-" + value);
                    currMap.put(key, value);
                    max = Math.max(value, max);
                    //System.out.println(" max:" + max);
                }
                map.clear();
                map.putAll(currMap);
            }
            if (max <= 1) {
                System.out.println(1);
            } else {
                System.out.println(max);
            }
        }
    }
}
