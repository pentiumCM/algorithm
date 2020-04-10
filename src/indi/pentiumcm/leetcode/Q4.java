package indi.pentiumcm.leetcode;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.leetcode
 * @className: Q4
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2020/3/18 9:35
 * @describe:
 */

//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}


public class Q4 {

    /**
     * 将倒序单链表采取数组储数据
     *
     * @param listNode
     * @return
     */
    public List<Integer> listToArr(ListNode listNode) {
        List<Integer> opt = new ArrayList<>();
        opt.add(listNode.val);
        while (listNode.next != null) {
            listNode = listNode.next;
            opt.add(listNode.val);
        }
        return opt;
    }


    /**
     * 将数据插入到单链表中
     *
     * @param num
     * @return
     */
    public ListNode addNode(long num) {
//      头结点
        ListNode header = null;

//      余数
        int rem = (int) (num % 10);
//      商
        long times = num / 10;

        header = new ListNode(rem);

        while (times > 0) {
            rem = (int) (times % 10);
            times = times / 10;

            ListNode e = new ListNode(rem);

            if (header.next == null)//第一次插入元素
            {
                header.next = e;
            } else//不是第一次插入元素
            {
                //temp引用在栈中，temp和header引用都指向堆中的initList()中new的Element对象
                ListNode temp = header;
                while (temp.next != null)//寻找最后一个元素
                {
                    temp = temp.next;
                }
                temp.next = e;
            }
        }
        return header;
    }


    /**
     * 两个单链表相加
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

//      头结点
        ListNode head = new ListNode(0);
        ListNode header1 = l1;
        ListNode header2 = l2;

        ListNode cur = head;

        int carry = 0;
        while (header1 != null || header2 != null) {
            int op1 = (header1 != null) ? header1.val : 0;
            int op2 = (header2 != null) ? header2.val : 0;

            int sum = carry + op1 + op2;
            carry = sum / 10;

            cur.next = new ListNode(sum % 10);
            cur = cur.next;

            if (header1 != null) {
                header1 = header1.next;
            }
            if (header2 != null) {
                header2 = header2.next;
            }
        }
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        return head.next;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(8);
        l1.next.next = new ListNode(7);


        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        l2.next.next.next = new ListNode(9);


        ListNode h = new Q4().addTwoNumbers(l1, l2);
    }
}
