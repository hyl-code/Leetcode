package July_2023;

/*
    给你单链表的头节点 head, 请你反转链表, 并返回反转后的链表.
 */
public class reverseList_206 {
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
