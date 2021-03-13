package indi.pentiumcm.leetcode;

import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;
import java.util.ArrayList;
import java.util.List;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.leetcode
 * @className: Q30
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2021/3/9 9:41
 * @describe:
 */
public class Q30 {


    public void dfs(int digitIndex, int n, List<Integer> path, int[] res) {

        // 遍历到叶子结点
        if (digitIndex > n) {
            res[0]++;

            return;
        }


        // 方案数
        for (Integer i = 0; i < 10; i++) {
            if (!path.contains(i)) {
                path.add(i);

                digitIndex++;
                dfs(digitIndex, n, path, res);

                // 回溯
                digitIndex--;
                path.remove(i);
            }
        }

    }

    public int countNumbersWithUniqueDigits(int n) {


        int[] res = new int[1];
        List<Integer> path = new ArrayList<>();

        dfs(1, n, path, res);

        if (n > 1) {
            res[0] += 1;

        }
        if (n > 2) {
            res[0] += 9 * (n - 2) * 2;
        }

        return res[0];
    }


    public static void main(String[] args) {

        int num = new Q30().countNumbersWithUniqueDigits(0);

        System.out.printf(num + "");


    }
}
