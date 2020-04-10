package indi.pentiumcm.leetcode;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.leetcode
 * @className: Q3
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2020/3/18 9:02
 * @describe: 矩形重合
 */
public class Q3 {

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int x1 = rec1[0], y1 = rec1[1];
        int x2 = rec1[2], y2 = rec1[3];
        int x3 = rec2[0], y3 = rec2[1];
        int x4 = rec2[2], y4 = rec2[3];

        if (x3 >= x2 || x1 >= x4 || y1 >= y4 || y3 >= y2) {
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
        int[] rect1 = {5, 15, 8, 18};
        int[] rect2 = {0, 3, 7, 9};

        boolean flag = new Q3().isRectangleOverlap(rect1, rect2);
    }
}
