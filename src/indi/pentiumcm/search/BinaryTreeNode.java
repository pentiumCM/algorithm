package indi.pentiumcm.search;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.search
 * @className: TreeNode
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2020/4/12 15:24
 * @describe: 二叉树数据结构
 */

/**
 * Definition for a binary tree node.
 *
 * @param <T> 二叉树节点的泛型
 */
public class BinaryTreeNode<T> {
    T val;
    BinaryTreeNode left;
    BinaryTreeNode right;

    BinaryTreeNode(T x) {
        val = x;
    }
}
