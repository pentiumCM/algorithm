package indi.pentiumcm.nowcoder.bytedance;

import java.util.Scanner;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.nowcoder
 * @className: Byte_19_3
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2020/4/3 23:36
 * @describe: 雀魂启动！ - 回溯法实现
 */
public class Byte_19_3 {

    /**
     * 判断是否可以胡牌
     *
     * @param cardCounts 牌对应的数量数组
     * @return
     */
    public boolean isWin(int[] cardCounts) {
        boolean flag = false;

        for (int i = 0; i < 9; i++) {
//          先选第 i 种牌为雀头
            if (cardCounts[i] < 2) {
                continue;
            }
            cardCounts[i] -= 2;

            if (hasThree(4, cardCounts)) {
                flag = true;
            }
            cardCounts[i] += 2;
        }
        return flag;
    }

    /**
     * 判断是否含有四个顺子或者刻子
     *
     * @param n
     * @param cardCounts
     * @return
     */
    public boolean hasThree(int n, int[] cardCounts) {
//      递归终止条件  
        if (n == 0) {
            return true;
        }

//      方案数为9，1~9每一个牌都可以拼成顺子或者刻子
        for (int i = 0; i < 9; i++) {
//          找到了一个刻子
            if (cardCounts[i] >= 3) {
                cardCounts[i] -= 3;
                boolean flag = hasThree(n - 1, cardCounts);
//              回溯
                cardCounts[i] += 3;

//              找到了 4 个刻子或者顺子
                if (flag) {
                    return true;
                }
            }

//          找到了一个顺子
            if (i < 7 && cardCounts[i] > 0 && cardCounts[i + 1] > 0 && cardCounts[i + 2] > 0) {
                cardCounts[i] -= 1;
                cardCounts[i + 1] -= 1;
                cardCounts[i + 2] -= 1;

                boolean flag = hasThree(n - 1, cardCounts);

//              回溯
                cardCounts[i] += 1;
                cardCounts[i + 1] += 1;
                cardCounts[i + 2] += 1;

                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {

        Byte_19_3 test = new Byte_19_3();

        Scanner in = new Scanner(System.in);

        int[] cards = new int[13];
        for (int i = 0; i < 13; i++) {
            cards[i] = in.nextInt();
        }

        int[] cardCounts = new int[9];
        for (int i = 0; i < cards.length; i++) {
            cardCounts[cards[i] - 1]++;
        }

        int winCount = 0;

//      从 1~9 中选择1张牌，作为第14张牌
        for (int i = 0; i < 9; i++) {
            if (cardCounts[i] < 4) {
                cardCounts[i]++;

//              判断是否可以胡牌
                if (test.isWin(cardCounts)) {
                    winCount++;
                    System.out.print(i + 1 + " ");
                }
                cardCounts[i]--;
            }
        }

        if (winCount == 0) {
            System.out.print(0);
        }

    }
}
