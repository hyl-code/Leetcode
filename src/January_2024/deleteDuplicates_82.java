package January_2024;

/*
    给定一个已排序的链表的头 head, 删除原始链表中所有重复数字的节点, 只留下不同的数字.
    返回已排序的链表.
 */
public class deleteDuplicates_82 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        if(head.val == head.next.val){
            while(next != null && head.val == next.val){
                next = next.next;
            }
            head = deleteDuplicates(next);
        }else{
            head.next = deleteDuplicates(next);
        }
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
