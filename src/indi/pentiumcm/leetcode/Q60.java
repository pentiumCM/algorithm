package indi.pentiumcm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.leetcode
 * @className: Q60
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2021/5/14 22:55
 * @describe: 1773. 统计匹配检索规则的物品数量
 */
public class Q60 {

    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int ans = 0;

        // items[i] = [typei, colori, namei]
        int queryIndex = 0;
        switch (ruleKey) {
            case "type":
                //语句
                queryIndex = 0;
                break; //可选
            case "color":
                //语句
                queryIndex = 1;
                break; //可选
            case "name":
                queryIndex = 2;
            default: //可选
                //语句
        }

        for (int i = 0; i < items.size(); i++) {
            List<String> list = items.get(i);
            String str = list.get(queryIndex);
            if (ruleValue.equals(str)) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        String[][] items = {
                {"phone", "blue", "pixel"}, {
                "computer", "silver", "lenovo"}, {
                "phone", "gold", "iphone"}};

        List<List<String>> lists = new ArrayList<>();
        for (int i = 0; i < items.length; i++) {
            String[] item = items[i];

            List<String> stringList = new ArrayList<>();
            for (int j = 0; j < item.length; j++) {
                stringList.add(item[j]);
            }
            lists.add(stringList);
        }

        String ruleKey = "color", ruleValue = "silver";
        int countMatches = countMatches(lists, ruleKey, ruleValue);

        System.out.println(countMatches);
    }

}
