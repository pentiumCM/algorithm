package indi.pentiumcm.leetcode;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.leetcode
 * @className: Q11
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2020/3/26 15:26
 * @describe: 999. 车的可用捕获量
 */
public class Q11 {

    public int numRookCapturesV2(char[][] board) {

        int len = board.length;
//      定义吃到卒的个数
        int count = 0;

//      定义方向数组
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

//      查找车的位置
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (board[i][j] == 'R') {
//                  上下左右四个方向分别移动
                    for (int k = 0; k < 4; k++) {
                        int x = i, y = j;
                        while (true) {
//                          移动一步的增量：(-1, 0)-向上移动 1 格
                            x += dx[k];
                            y += dy[k];
//                          移动超出棋盘
                            if (x <= 0 || x >= 8 || y <= 0 || y >= 8) {
                                break;
                            }
//                          移动到白象的位置
                            else if (board[x][y] == 'B') {
                                break;
                            } else if (board[x][y] == 'p') {
                                count++;
                                break;
                            }
                        }
                    }
                    return count;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        char[][] boards = {{'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'R', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'}};

        int num = new Q11().numRookCapturesV2(boards);
    }
}
