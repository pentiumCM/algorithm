package indi.pentiumcm.subject.linkedlist;

import java.util.*;

/**
 * @projName: algorithm
 * @packgeName: PACKAGE_NAME
 * @className: indi.pentiumcm.subject.linkedlist.Reversal
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2021/3/17 23:03
 * @describe: 测试类
 */
public class Reversal {

    /**
     * 迭代反转链表
     *
     * @param head
     * @return
     */
    public static ListNode ReverseList_v1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode front = null;
        ListNode mid = head;
        ListNode back = head.next;

        while (mid.next != null) {
            mid.next = front;

            // 往后推移一位
            front = mid;
            mid = back;
            back = back.next;
        }
        mid.next = front;
        return mid;
    }

    /**
     * 递归反转链表
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        //得到当前节点的下一节点
        ListNode next = head.next;

        //打断当前指针链
        head.next = null;

        //每次递归下一节点进行反转
        ListNode re = reverseList(next);

        //反转指针域
        next.next = head;
        return re;
    }


    /**
     * 头插法 实现 单链表反转
     *
     * @param head
     * @return
     */
    public static ListNode reverseList_headInsert(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = null;
        ListNode temp = null;

        while (head != null) {
            temp = head;
            head = head.next;

            temp.next = newHead;
            newHead = temp;

        }

        return newHead;
    }


    /**
     * 检验单链表是否有环，使用列表存储，列表中已有该元素，说明有环
     *
     * @param head
     * @return
     */
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        List<ListNode> arr = new ArrayList<>();

        while (head != null) {
            if (arr.contains(head)) {
                return true;
            } else {
                arr.add(head);
                head = head.next;
            }
        }
        return false;
    }


    /**
     * 检验单链表是否有环，使用快慢两个指针
     *
     * @param head
     * @return
     */
    public static boolean hasCycle_v2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {

        ArrayList<Integer> ans = new ArrayList<>();

        if (k > input.length) {
            return ans;
        }

        Arrays.sort(input);

        for (int i = 0; i < k; i++) {
            ans.add(input[i]);
        }
        return ans;
    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

//        l5.next = l3;

        boolean flag = hasCycle_v2(l1);


        System.out.println("");
    }

}

class ListNode {

    int val;
    ListNode next;

    public ListNode(int x) {
        this.val = x;
    }

    public ListNode() {
        this.val = 0;
        this.next = null;
    }

}

