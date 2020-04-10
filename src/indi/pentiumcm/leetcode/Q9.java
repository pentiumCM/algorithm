package indi.pentiumcm.leetcode;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.leetcode
 * @className: Q9
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2020/3/23 10:35
 * @describe: 876. 链表的中间结点
 */
public class Q9 {


    public int listSize(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    //  单指针法
    public ListNode middleNode(ListNode head) {
        int size = listSize(head);
//      获取中间节点的索引位置
        int mid = (int) Math.ceil((1.0 + size) / 2);

        int i = 1;
        while (i != mid) {
            head = head.next;
            i++;
        }
        return head;
    }


    //  快慢指针法
    public ListNode middleNodeV2(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);

        ListNode l2 = new Q9().middleNode(l1);
    }
}

