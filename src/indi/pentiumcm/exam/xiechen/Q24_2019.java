package indi.pentiumcm.exam.xiechen;


import java.util.*;

import java.util.Scanner;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.exam.xiechen
 * @className: Q24_2019
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2021/3/17 21:32
 * @describe:
 */
public class Q24_2019 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        in.nextLine();

        Map<Integer, Integer> map = new HashMap<>(size);
        LinkedList<Integer> list = new LinkedList<>();
        while (in.hasNextLine()) {
            String[] strings = in.nextLine().split(" ");
            if (strings[0].equals("p")) {
                int key = Integer.parseInt(strings[1]);
                int value = Integer.parseInt(strings[2]);
                if (!map.containsKey(key)) {
                    map.put(key, value);
                    list.addLast(key);
                    if (list.size() > size) {
                        map.remove(list.removeFirst());
                    }
                } else {
                    map.put(key, value);
                }
            } else {
                int key = Integer.parseInt(strings[1]);
                if (!map.containsKey(key)) {
                    System.out.println(-1);
                    continue;
                } else {
                    System.out.println(map.get(key));
                }
                Iterator<Integer> iterator = list.iterator();
                while (iterator.hasNext()) {
                    if (key == iterator.next()) {
                        iterator.remove();
                    }
                }
                list.addLast(key);
            }
        }
        in.close();
    }

}
