package indi.pentiumcm.nowcoder.bytedance;

import java.util.Scanner;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.nowcoder
 * @className: Byte_19_6
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2020/4/10 13:29
 * @describe: 找零
 */
public class Byte_19_6 {


    /**
     * 贪心算法 - 找零
     *
     * @param n
     * @return
     */
    public int getChanges(int n) {
        int n64 = n / 64;
        int n16 = (n - n64 * 64) / 16;
        int n4 = (n - n64 * 64 - n16 * 16) / 4;
        int n1 = n - n64 * 64 - n16 * 16 - n4 * 4;
        return n64 + n16 + n4 + n1;
    }


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

//      商品价值
        int N = in.nextInt();

        int changeCount = new Byte_19_6().getChanges(1024 - N);

        System.out.print(changeCount);

    }
}
