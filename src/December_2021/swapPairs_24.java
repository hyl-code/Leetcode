package December_2021;

/*
    给你一个链表, 两两交换其中相邻的节点, 并返回交换后链表的头节点 .
    你必须在不修改节点内部的值的情况下完成本题 (即, 只能进行节点交换) .
 */

public class swapPairs_24 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }
}
