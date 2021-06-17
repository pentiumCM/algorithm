package indi.pentiumcm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.leetcode
 * @className: Q63
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2021/5/15 9:22
 * @describe: 1832. 判断句子是否为全字母句
 */
public class Q63 {

    public static boolean checkIfPangram(String sentence) {
        // 小写字母ASCALL从97开始，个数26个
        List<Integer> list = new ArrayList<>();
        for (int i = 97; i < 97 + 26; i++) {
            list.add(i);
        }

        for (int i = 0; i < sentence.length(); i++) {
            int item = sentence.charAt(i);
            list.remove((Object) item);
        }

        if (list == null || list.size() == 0) {
            return true;
        }
        return false;
    }


    public static boolean checkIfPangram_V2(String sentence) {
        int[] ans = new int[26];

        for (int i = 0; i < sentence.length(); i++) {
            int item = sentence.charAt(i);

            ans[item - 'a'] = 1;
        }

        int count = 0;
        for (int i = 0; i < ans.length; i++) {
            count += ans[i];
        }
        if (count == 26) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {

        String sentence = "thequickbrownfoxjumpsoverthelazydog";

        final boolean b = checkIfPangram(sentence);

        char a = 'a';
        char A = 'A';

        System.out.println(a);

        System.out.println(A);
    }
}
