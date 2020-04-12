package indi.pentiumcm.leetcode;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.leetcode
 * @className: Q22
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2020/4/11 22:09
 * @describe: LeetCode 104. 二叉树的最大深度
 */
public class Q22 {

    public int maxDepth = 0;

    /**
     * 回溯法 - 遍历二叉树
     *
     * @param root
     * @param curDepth 当前深度
     */
    public int dfs(TreeNode root, int curDepth) {
//      遍历到叶子节点
        if (root.left == null && root.right == null) {
            if (curDepth > maxDepth) {
                maxDepth = curDepth;
                return maxDepth;
            }
        }

//      方案数为2，遍历左节点和遍历右节点
        for (int i = 0; i < 2; i++) {
            if (i == 0) {
                if (root.left != null) {
                    curDepth += 1;
                    dfs(root.left, curDepth);
                    curDepth -= 1;
                }
            } else {
                if (root.right != null) {
                    curDepth += 1;
                    dfs(root.right, curDepth);
                    curDepth -= 1;
                }
            }
        }
        return maxDepth;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int depth = dfs(root, 1);
        return depth;
    }


    /**
     * 递归来求二叉树的深度度
     *
     * @param root
     * @return
     */
    public int maxDepthV2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDep = maxDepthV2(root.left);
        int rightDep = maxDepthV2(root.right);

        return 1 + Math.max(leftDep, rightDep);
    }


    /**
     * 广度优先搜索 - 利用栈队列来遍历二叉树
     *
     * @param root
     * @return
     */
    public int maxDepthV3(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, 1));

        int depth = 0;
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> queueHead = queue.poll();

            TreeNode curNode = queueHead.getKey();
            Integer curDepth = queueHead.getValue();

            depth = Math.max(depth, curDepth);
            if (curNode.left != null) {
                queue.add(new Pair<>(curNode.left, curDepth + 1));
            }
            if (curNode.right != null) {
                queue.add(new Pair<>(curNode.right, curDepth + 1));
            }
        }
        return depth;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);

        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int max = new Q22().maxDepthV3(root);
    }
}

//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
