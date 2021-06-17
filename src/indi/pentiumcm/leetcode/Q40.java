package indi.pentiumcm.leetcode;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.leetcode
 * @className: Q40
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2021/3/16 10:40
 * @describe: leetcode —— 867. 转置矩阵
 */
public class Q40 {


    public int[][] transpose(int[][] matrix) {

        int rowNum = matrix.length;
        int colNum = matrix[0].length;

        int[][] ans = new int[colNum][rowNum];
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                ans[j][i] = matrix[i][j];
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        int[][] matrix = {{1, 2, 3}, {4, 5, 6}};

        new Q40().transpose(matrix);
    }
}
