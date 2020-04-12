package indi.pentiumcm.search;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.search
 * @className: BinaryTree
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2020/4/12 14:44
 * @describe: 二叉树遍历算法
 */
public class BinaryTreeTraverse {

    /**
     * 前序遍历，同深度优先遍历二叉树，根
     */
    public void preOrder(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
//      遍历根节点
        System.out.print(root.val + " ");

//      遍历左子树
        preOrder(root.left);

//      遍历右子树
        preOrder(root.right);
    }


    /**
     * 中序遍历，左根右
     */
    public void inOrder(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
//      遍历左子树
        inOrder(root.left);
//      遍历根节点
        System.out.print(root.val + " ");
//      遍历右子树
        inOrder(root.right);
    }


    /**
     * 后序遍历，左右根
     */
    public void postOrder(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
//      遍历左子树
        postOrder(root.left);
//      遍历右子树
        postOrder(root.right);
//      遍历根节点
        System.out.print(root.val + " ");
    }


    public static void main(String[] args) {
//      构建二叉树
        BinaryTreeNode root = new BinaryTreeNode(3);
        root.left = new BinaryTreeNode(9);

        root.right = new BinaryTreeNode(20);
        root.right.left = new BinaryTreeNode(15);
        root.right.left.right = new BinaryTreeNode(30);

        root.right.right = new BinaryTreeNode(7);


//      遍历二叉树
        System.out.print("前序：");
        new BinaryTreeTraverse().preOrder(root);
        System.out.print("\n");

        System.out.print("中序：");
        new BinaryTreeTraverse().inOrder(root);
        System.out.print("\n");

        System.out.print("后序：");
        new BinaryTreeTraverse().postOrder(root);
        System.out.print("\n");
    }

}
