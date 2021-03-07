package indi.pentiumcm.leetcode;

import indi.pentiumcm.datastructure.Node;
import javafx.util.Pair;

import java.util.*;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.leetcode
 * @className: Q23
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2020/4/12 16:06
 * @describe: LeetCode 559. N叉树的最大深度
 */
public class Q23 {

    /**
     * BFS 广度优先遍历 - 利用队列
     *
     * @param root
     * @return
     */
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }

        Queue<Pair<Node, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, 1));

        int depth = 0;
        while (!queue.isEmpty()) {
            Pair<Node, Integer> curPair = queue.poll();

            Node curNode = curPair.getKey();
            int curDepth = curPair.getValue();
            depth = Math.max(depth, curDepth);

            for (int i = 0; i < curNode.children.size(); i++) {
                queue.add(new Pair<>(curNode.children.get(i), curDepth + 1));
            }

        }
        return depth;
    }


    /**
     * DFS 深度优先遍历，递归调用
     *
     * @param root
     * @return
     */
    public int maxDepthV2(Node root) {
        int maxDepth = 0;
        if (root == null) {
            return 0;
        }
        if (root.children == null) {
            return 1;
        }
        for (int i = 0; i < root.children.size(); i++) {
            int curDepth = maxDepthV2(root.children.get(i));
            maxDepth = Math.max(curDepth, maxDepth);
        }
        return 1 + maxDepth;
    }


    public static void main(String[] args) {
        Node root = new Node(1);

        root.children = new LinkedList<>();
        root.children.add(new Node(3));
        root.children.add(new Node(2));
        root.children.add(new Node(4));

        root.children.get(0).children = new LinkedList<>();
        root.children.get(0).children.add(new Node(5));
        root.children.get(0).children.add(new Node(6));

        int h = new Q23().maxDepthV2(root);
    }

}


;