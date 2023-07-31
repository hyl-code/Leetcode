package July_2023;

/*
    给定一个单链表 L 的头节点 head, 单链表 L 表示为：
        L0 → L1 → … → Ln - 1 → Ln
    请将其重新排列后变为：
        L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
    不能只是单纯的改变节点内部的值, 而是需要实际的进行节点交换.
 */
public class reorderList_143 {
    public void reorderList(ListNode head) {
        if(head == null){
            return;
        }
        ListNode mid = middleNode(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null;
        l2 = reverseList(l2);
        mergeList(l1, l2);
    }

    private ListNode middleNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverseList(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    private void mergeList(ListNode l1, ListNode l2){
        ListNode l1_tmp;
        ListNode l2_tmp;
        while(l1 != null && l2 != null){
            l1_tmp = l1.next;
            l2_tmp = l2.next;
            l1.next = l2;
            l1 = l1_tmp;
            l2.next = l1;
            l2 = l2_tmp;
        }
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
