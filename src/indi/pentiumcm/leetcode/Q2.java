package indi.pentiumcm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.leetcode
 * @className: Q2
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2020/3/17 14:16
 * @describe: spell word
 */
public class Q2 {

    /**
     * 将字母表中的单词用map存储，key字母，value字母数量
     *
     * @param chars 待哈希存储的字符串
     * @return
     */
    public Map<Character, Integer> getCharMap(String chars) {
        if (chars.length() <= 0) {
            return null;
        }
//      将字母表中的单词用map存储，key字母，value字母数量
        Map<Character, Integer> charMap = new HashMap<>();
        for (int i = 0; i < chars.length(); i++) {
            Character c = chars.charAt(i);
            Integer count = charMap.getOrDefault(c, 0);
            charMap.put(c, ++count);
        }
        return charMap;
    }


    /**
     * 拼写单词
     *
     * @param words
     * @param chars
     * @return
     */
    public int countCharacters(String[] words, String chars) {
        if (chars.length() <= 0 || words.length <= 0) {
            return 0;
        }
//      将字母表中的单词用map存储，key字母，value字母数量
        Map<Character, Integer> charMap = getCharMap(chars);


        int charRemNum = 0;
//      遍历词汇表，取出里面的每一个单词
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            Map<Character, Integer> wordMap = getCharMap(word);

            int keyCount = wordMap.keySet().size();
            int j = 0;
            for (Character key : wordMap.keySet()) {
                Integer wordNum = wordMap.getOrDefault(key, 0);
                Integer charNum = charMap.getOrDefault(key, 0);
                if (charNum >= wordNum) {
                    ++j;
                    if (j == keyCount) {
                        charRemNum += word.length();
                    }
                }
            }
        }
        return charRemNum;
    }

    public static void main(String[] args) {
        String[] words = {"cat", "bt", "hat", "tree"};
        String chars = "atach";
        int num = new Q2().countCharacters(words, chars);

    }
}
