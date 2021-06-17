package indi.pentiumcm.tags.bt;

import java.util.ArrayList;
import java.util.List;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.thought
 * @className: BtBack
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2020/4/4 17:47
 * @describe: 回溯法 - 0/1背包问题
 */
public class BtBack {

    // 背包容量
    public int backCap = 8;
    // 物品个数
    public int goodNums = 4;
    // 物品的重量
    int[] weights = {2, 3, 4, 5};
    // 物品的价值
    int[] values = {3, 4, 5, 6};

    // 表示第 i 个物品是否放入背包
    int[] places = new int[goodNums];

    // 当前背包放入物体的重量
    public int curWeight = 0;
    // 当前价值
    public int curVals = 0;
    // 最大价值
    public int maxVals = 0;

    /**
     * 处理第 i 个物体
     *
     * @param i 第 i 个物体
     */
    public int backtrack(int i, List<Integer[]> res) {
//      递归的终止条件
//      遍历完所有的物品，即到叶子节点
        if (i == goodNums) {
            Integer[] resArr = {0, 0, 0, 0, 0};
            for (int j = 0; j < goodNums; j++) {
                resArr[j] = places[j];
            }
            resArr[goodNums] = curVals;
            res.add(resArr);
            if (curVals > maxVals) {
                maxVals = curVals;
            }
            return maxVals;
        }

//      第 i 个物品的重量
        int weight = weights[i];

//      方案数为 2，方案1用0表示 - 不装第i个物体，方案2用1表示 - 装第i个物体
        for (int j = 0; j < 2; j++) {
//          不装第 i 个物品
            if (j == 0) {
                places[i] = 0;
//              遍历下一个物品
                backtrack(i + 1, res);
            }
//          装第 i 个物品
            else {
//              剪枝处理，判断第 i 个物品是否可以装进背包
                curWeight = arrmultiply(places, weights);
                if (curWeight + weight <= backCap) {
                    places[i] = 1;
                    curVals = arrmultiply(places, values);
                    backtrack(i + 1, res);
                    places[i] = 0;
                }
            }
        }
        return maxVals;
    }

    public int arrmultiply(int[] arr1, int[] arr2) {
        int result = 0;
        if (arr1.length == arr2.length) {
            for (int i = 0; i < arr1.length; i++) {
                result += arr1[i] * arr2[i];
            }
        } else {
            System.out.print("数组长度不一致！");
        }
        return result;
    }

    public static void main(String[] args) {
        BtBack btBack = new BtBack();
//      存放解空间的解
        List<Integer[]> res = new ArrayList<>();
        int max = btBack.backtrack(0, res);

        System.out.println("最大价值为：" + max);

        System.out.println("背包中的物品组合及价值（最后一位为价值）：");
        for (int i = 0; i < res.size(); i++) {
            Integer[] arr = res.get(i);
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[j] + "  ");
            }
            System.out.print("\n");
        }
    }
}
