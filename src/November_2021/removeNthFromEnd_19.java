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
        while(n != 0){
            fast = fast.next;
            n--;
        }
        if(fast == null)
            return head.next;
        fast = fast.next;
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
