package July_2023;

/*
    给你一个链表, 删除链表的倒数第 n 个结点, 并且返回链表的头结点.
 */
public class removeNthFromEnd_19 {
    // 快指针先走 n 步, 然后快慢一起走, 直到快指针走到最后.
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        while(n != 0){
            fast = fast.next;
            n--;
        }
        if(fast == null){
            return head.next;
        }
        fast = fast.next;
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
