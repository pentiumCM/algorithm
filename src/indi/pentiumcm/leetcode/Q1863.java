package indi.pentiumcm.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.leetcode
 * @className: Q1863
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2021/5/27 9:54
 * @describe:
 */
public class Q1863 {


    public List<List> subsetXORSum(int[] nums) {
        int ans = 0;
        // 解空间结果
        List<List> res = new ArrayList<>();
        // 当前路径
        Stack<Integer> path = new Stack<>();

        dfs(nums, 0, path, res);
        return res;
    }

    /**
     * 深度优先遍历
     *
     * @param nums     待遍历集合
     * @param curIndex 当前遍历索引
     * @param path     当前遍历路径
     * @param res      解空间
     */
    public void dfs(int[] nums, int curIndex, Stack<Integer> path, List<List> res) {
        // 叶子节点
        if (curIndex == nums.length) {
            List<Integer> temp = new ArrayList<>();
            path.stream().forEach(integer -> temp.add(integer));

            // 解空间记录当前解
            res.add(temp);
            return;
        }

        // 方案：0-不取，1-取
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            // 遍历当前值
            Integer curVal = nums[i];
            if (!path.contains(curVal)) {
                path.push(curVal);
                curIndex++;

                dfs(nums, curIndex, path, res);

                path.pop();
                curIndex--;
            }
        }
    }


    public static void main(String[] args) {
        int[] nums = {5, 1, 6};

        Q1863 q1863 = new Q1863();

        q1863.subsetXORSum(nums);

        System.out.println();
    }
}
