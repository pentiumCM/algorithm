package indi.pentiumcm.leetcode;

import java.util.List;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.leetcode
 * @className: Q52
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2021/5/4 17:19
 * @describe: 面试题 02.03. 删除中间节点
 */
public class Q52 {

    public static void deleteNode(ListNode node) {
        ListNode pre = node;
        ListNode cur = node;
        ListNode next = pre.next;

        while (next != null) {

            cur.val = next.val;

            pre = cur;
            cur = next;
            next = next.next;
        }
        pre.next = null;
    }


    public static void deleteNode_v2(ListNode node) {

        node.val = node.next.val;

        node.next = node.next.next;

    }


    public static void main(String[] args) {
//        [4,5,1,9]

        ListNode root = new ListNode(4);
        root.next = new ListNode(5);
        root.next.next = new ListNode(1);
        root.next.next.next = new ListNode(9);

        deleteNode_v2(root.next);

        System.out.println();
    }

}
