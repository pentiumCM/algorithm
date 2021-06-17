package indi.pentiumcm.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.leetcode
 * @className: Q58
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2021/5/10 21:38
 * @describe: 872. 叶子相似的树
 */
public class Q58 {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<TreeNode> bfs1 = bfs(root1);
        List<TreeNode> bfs2 = bfs(root2);

        int len1 = bfs1.size();
        int len2 = bfs2.size();
        if (len1 != len2) {
            return false;
        }

        for (int i = 0; i < len1; i++) {
            TreeNode treeNode1 = bfs1.get(i);
            TreeNode treeNode2 = bfs2.get(i);
            if (treeNode1.val != treeNode2.val) {
                return false;
            }
        }
        return true;
    }


    /**
     * 广度优先遍历二叉树
     *
     * @param root
     * @return
     */
    public List<TreeNode> bfs(TreeNode root) {

        // 广度优先遍历 —— 队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<TreeNode> leaf = new ArrayList<>();

        while (!queue.isEmpty()) {
            // 获取队首元素
            TreeNode head = queue.poll();

            // 获取左右孩子结点
            TreeNode left = head.left;
            TreeNode right = head.right;
            if (left == null && right == null) {
                leaf.add(head);
            }
            if (left != null) {
                queue.add(left);
            }
            if (right != null) {
                queue.add(right);
            }
        }
        return leaf;
    }


    public static void main(String[] args) {

        TreeNode r1 = new TreeNode(1);
        r1.left = new TreeNode(2);
        r1.right = null;
        r1.left.left = new TreeNode(3);

        TreeNode r2 = new TreeNode(1);
        r2.left = new TreeNode(3);


//        [1,2,null,3]
//        [1,3]


        Q58 q58 = new Q58();
        q58.leafSimilar(r1, r2);
    }
}
