package August_2023;

/*
    给你一个链表数组, 每个链表都已经按升序排列.
    请你将所有链表合并到一个升序链表中, 返回合并后的链表.
 */
public class mergeKLists_23 {
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int l, int r){
        if(l == r){
            return lists[l];
        }
        if(l > r){
            return null;
        }
        int mid = (l + r) >> 1;
        return mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));
    }

    public ListNode mergeTwoLists(ListNode a, ListNode b){
        if(a == null || b == null){
            return a != null ? a : b;
        }
        ListNode head = new ListNode(0);
        ListNode tail = head, ap = a, bp = b;
        while(ap != null && bp != null){
            if(ap.val < bp.val){
                tail.next = ap;
                ap = ap.next;
            }else{
                tail.next = bp;
                bp = bp.next;
            }
            tail = tail.next;
        }
        tail.next = (ap != null ? ap : bp);
        return head.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
