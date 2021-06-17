package indi.pentiumcm.leetcode;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.leetcode
 * @className: Q54
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2021/5/6 12:05
 * @describe: 771. 宝石与石头
 */
public class Q54 {

    public static int numJewelsInStones(String jewels, String stones) {

        int ans = 0;
        char[] chars = jewels.toCharArray();
        for (int i = 0; i < stones.length(); i++) {
            char item = stones.charAt(i);
            for (int j = 0; j < chars.length; j++) {

                char tar = chars[j];
                if (tar == item) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        String J = "aA", S = "aAAbbbb";

        int jewelsInStones = numJewelsInStones(J, S);
        System.out.println(jewelsInStones);
    }
}
