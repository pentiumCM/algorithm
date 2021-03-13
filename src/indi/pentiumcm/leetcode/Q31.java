package indi.pentiumcm.leetcode;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.leetcode
 * @className: Q31
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2021/3/10 10:08
 * @describe: leetcode - 1688. 比赛中的配对次数
 */
public class Q31 {


    public void dfs(int n, int[] res) {

        // 到达叶子结点
        if (n == 1) {
            return;
        }

        // 奇数
        if (n % 2 != 0) {
            int n1 = (n - 1) / 2;
            res[0] += n1;
            dfs(n1 + 1, res);
        } else {

            int n2 = n / 2;
            res[0] += n2;
            dfs(n2, res);
        }
    }

    public int numberOfMatches(int n) {
        int[] res = new int[1];
        dfs(n, res);
        return res[0];
    }


    public static void main(String[] args) {
        int i = new Q31().numberOfMatches(7);

        System.out.printf("i：" + i);
    }
}
