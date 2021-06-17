package indi.pentiumcm.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.leetcode
 * @className: Q47
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2021/4/27 14:24
 * @describe: 938. 二叉搜索树的范围和
 */
public class Q47 {


    /**
     * 广度优先的方式遍历二叉树
     *
     * @param root
     * @param low
     * @param high
     * @return
     */
    public static int rangeSumBST(TreeNode root, int low, int high) {
        // 采用队列才存储二叉树
        int ans = 0;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            int val = treeNode.val;
            if (val >= low && val <= high) {
                ans += val;
            }
            TreeNode left = treeNode.left;
            TreeNode right = treeNode.right;

            if (left != null) {
                queue.add(left);
            }
            if (right != null) {
                queue.add(right);
            }
        }
        return ans;
    }


    /**
     * 深度优先的方式遍历二叉树
     *
     * @param root
     * @param low
     * @param high
     * @return
     */
    public static int rangeSumBST_dfs(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (root.val > high) {
            return rangeSumBST_dfs(root.left, low, high);
        }
        if (root.val < low) {
            return rangeSumBST_dfs(root.right, low, high);
        }
        return root.val + rangeSumBST_dfs(root.left, low, high) + rangeSumBST_dfs(root.right, low, high);
    }


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(10);

        treeNode.left = new TreeNode(5);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(7);

        treeNode.right = new TreeNode(15);
        treeNode.right.right = new TreeNode(18);


        int low = 7, high = 15;

        int ans = rangeSumBST(treeNode, low, high);

        System.out.println(ans);

    }

}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
