package indi.pentiumcm.search;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.search
 * @className: DFS
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2020/4/12 14:25
 * @describe: 深度优先搜索
 */
public class DFS {


    /**
     * 深度优先遍历二叉树，即前序遍历
     */
    public void dfs(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
//      遍历根节点
        System.out.print(root.val + " ");

//      遍历左子树
        dfs(root.left);

//      遍历右子树
        dfs(root.right);
    }


    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(3);
        root.left = new BinaryTreeNode(9);

        root.right = new BinaryTreeNode(20);
        root.right.left = new BinaryTreeNode(15);
        root.right.right = new BinaryTreeNode(7);

        new DFS().dfs(root);
    }
}


