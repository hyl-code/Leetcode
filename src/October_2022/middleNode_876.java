package October_2022;

public class middleNode_876 {
    //慢指针: p, 快指针: q
    public ListNode middleNode(ListNode head) {
        ListNode p = head, q = head;
        while(q != null && q.next != null){
            q = q.next.next;
            p = p.next;
        }
        return p;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
