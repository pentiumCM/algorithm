package indi.pentiumcm.nowcoder.bytedance;

import java.util.Scanner;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.nowcoder
 * @className: Byte_19_7
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2020/4/10 13:45
 * @describe: 机器人跳跃问题
 */
public class Byte_19_7 {

    /**
     * 获取机器人的最初动能 - 从后往前逆推
     * 最理想的情况是跳完最后一个能力刚好为0或者为1，因此 用ceil函数处理
     *
     * @param h
     * @return
     */
    public int getInitE(int[] h) {
        int e = 0;
        for (int i = h.length - 1; i >= 0; i--) {
            e = (int) Math.ceil((e + h[i]) / 2.0);
        }
        return e;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

        int[] heights = new int[N];

        for (int i = 0; i < N; i++) {
            heights[i] = in.nextInt();
        }

        int e = new Byte_19_7().getInitE(heights);
        System.out.print(e);
    }
}
