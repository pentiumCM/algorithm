package indi.pentiumcm.nowcoder.meituan.ms;

/**
 * @projName: algorithm
 * @packgeName: PACKAGE_NAME
 * @className: Main1
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2021/3/17 23:03
 * @describe: 反装列表
 */
public class Main1 {


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


    public static void main(String[] args) {

        ListNode r1 = new ListNode(1);
        ListNode r2 = new ListNode(2);
        ListNode r3 = new ListNode(3);
        ListNode r4 = new ListNode(4);

        r1.next = r2;
        r2.next = r3;
        r3.next = r4;

        ListNode listNode = reverseList(r1);
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

