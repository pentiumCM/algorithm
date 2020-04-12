package indi.pentiumcm.nowcoder.bytedance;

import java.util.*;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm
 * @className: Q1
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2020/3/15 19:37
 * @describe:
 */
public class Byte_20_Q1 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

//      用户类型 N
        int N = in.nextInt();

//      将用户类型和模型类型 使用哈希表进行存储。模型类型为key，用户类型为value
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
//          用户类型 abc
            String userType = in.next();
//          模型类型 1.txt
            String modelType = in.next();

            if (!map.containsKey(modelType)) {
                List<String> userTypeList = new ArrayList<>();
                userTypeList.add(userType);
                map.put(modelType, userTypeList);
            } else {
                map.get(modelType).add(userType);
            }
        }

        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            List<String> userTypeList = map.get(key);
            String[] userArr = new String[userTypeList.size()];
            for (int i = 0; i < userTypeList.size(); i++) {
                userArr[i] = userTypeList.get(i);
            }
            Arrays.sort(userArr);
            StringBuffer sb = new StringBuffer();
            sb.append(userArr[0]);
            for (int i = 1; i < userArr.length; i++) {
                sb.append(" ").append(userArr[i]);
            }
            System.out.println(key + " " + sb);
        }
    }

}

