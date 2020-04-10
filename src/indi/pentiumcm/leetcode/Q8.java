package indi.pentiumcm.leetcode;

import java.util.Arrays;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.leetcode
 * @className: Q8
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2020/3/22 9:50
 * @describe: 945. 使数组唯一的最小增量
 */
public class Q8 {

    public int minIncrementForUnique(int[] A) {
        int[] count = new int[80000];
        for (int x : A) {
            count[x]++;
        }

//      总操作次数
        int inAllCount = 0;
        int countI = 0;
        for (int i = 0; i < count.length - 1; i++) {
            if (count[i] >= 2) {
//              第 i 位置上元素移到到 i+1 位置上的操作次数。（加法的进位思想）
                countI = count[i] - 1;
                count[i + 1] += countI;
//              进位完，加第 i 个位置上元素的个数置为1
                count[i] = 1;
                inAllCount += countI;
            }
        }
        return inAllCount;
    }


    /**
     * 贪心算法解决
     *
     * @param A
     * @return
     */
    public static int minIncrementForUniqueV2(int[] A) {
        if (A.length < 2) {
            return 0;
        }
        Arrays.sort(A);
        int count = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] <= A[i - 1]) {//只要比上一个小或者和上一个相同，我们对此加1即可
                A[i] += 1;
                count++;
                i--;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        int[] A = {3, 2, 1, 2, 1, 7};
        int count = new Q8().minIncrementForUnique(A);
    }
}
