package indi.pentiumcm;

import java.util.*;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm
 * @className: Q3
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2020/3/12 22:29
 * @describe: 字节跳动 - 2018后端2面 -Q3
 */
public class eighteen_Q3 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

//      字符串S
        String s = in.next();
//      交换次数
        int m = in.nextInt();

        Map<Character, List<Integer>> sMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (!sMap.containsKey(c)) {
                List<Integer> posList = new ArrayList<>();
                posList.add(i);
                sMap.put(c, posList);
            } else {
                sMap.get(c).add(i);
            }
        }

        int max = 0;
        Set<Character> keySet = sMap.keySet();
        for (Character key : keySet) {
            List<Integer> posList = sMap.get(key);

            for (int i = 0; i < posList.size(); i++) {
//              定义某一种字母的 中心 ctr
                int ctr = posList.get(i);
//              创建这种字母中每个字母移动步数数组
                int move[] = new int[posList.size()];
//              获取 move[]，表示每个相同字母到中心点 ctr 需要移动的最少步数
                for (int j = 0; j < posList.size(); j++) {
//                  Math.abs(list.get(j)-ctr)是实际字符串相隔几步
//                  Math.abs(j-i)在同一个字符数组相隔的距离，这时不要想里面的数，光想这个数组的下标
                    move[j] = Math.abs(posList.get(j) - ctr) - Math.abs(j - i);
                }

//              排序后，选择移动代价最少的前 k + 1 个
                Arrays.sort(move);
                int sum = 0;
                for (int k = 0; k < move.length; k++) {
                    sum += move[k];
                    if (sum > m) {
                        break;
                    }
                    if (k + 1 > max) {
                        max = k + 1;
                    }
                }
            }
        }
        System.out.println(max);
    }

}
