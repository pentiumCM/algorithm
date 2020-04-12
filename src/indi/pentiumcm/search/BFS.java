package indi.pentiumcm.search;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.search
 * @className: BFS
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2020/4/12 14:32
 * @describe: 广度优先搜索
 */
public class BFS {

    /**
     * 广度优先遍历二叉树 - 利用队列
     *
     * @param root
     */
    public void bfs(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryTreeNode curNode = queue.poll();
            System.out.print(curNode.val + " ");

            if (curNode.left != null) {
                queue.add(curNode.left);
            }
            if (curNode.right != null) {
                queue.add(curNode.right);
            }
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(3);
        root.left = new BinaryTreeNode(9);

        root.right = new BinaryTreeNode(20);
        root.right.left = new BinaryTreeNode(15);
        root.right.left.right = new BinaryTreeNode(30);

        root.right.right = new BinaryTreeNode(7);

        new DFS().dfs(root);
        System.out.print("\n");
        new BFS().bfs(root);
    }
}
