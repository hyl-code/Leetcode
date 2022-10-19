package November_2021;

/*
    给你一个链表, 删除链表的倒数第 n 个结点, 并且返回链表的头结点.
 */

public class removeNthFromEnd_19 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        //fast 指针到达第 n 个结点
        while(n != 0){
            fast = fast.next;
            n--;
        }
        //若 fast == null, 说明倒数第 n 个结点为头结点
        if(fast == null)
            return head.next;
        //为了使得 slow 指针到达倒数第 n 个结点时, fast指针指向为空
        fast = fast.next;
        //循环寻找第 n 个结点, 当 fast 指向为空, 则 slow 指针指向倒数第 n 个结点
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        //删除倒数第 n 个结点
        slow.next = slow.next.next;
        return head;
    }
}
