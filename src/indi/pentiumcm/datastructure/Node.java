package indi.pentiumcm.datastructure;

import java.util.List;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.leetcode
 * @className: Node
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2020/7/3 16:53
 * @describe:
 */
// Definition for a Node.
public class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
