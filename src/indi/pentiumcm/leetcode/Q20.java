package indi.pentiumcm.leetcode;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.leetcode
 * @className: Q20
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2020/4/7 16:15
 * @describe: LeetCode- 面试题 01.07. 旋转矩阵
 */
public class Q20 {

    public void rotate(int[][] matrix) {
        int row = matrix.length;
        if (matrix.length <= 0) {
            return;
        }


//      遍历第 i 行
        for (int i = 0; i < matrix.length; i++) {
//          按列来遍历第 i 行的每一个元素
            for (int j = 0; j < matrix[i].length; j++) {

                int temp = matrix[j][row - i - 1];

                matrix[j][row - i - 1] = matrix[i][j];
            }
        }

    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

        new Q20().rotate(matrix);

    }
}
