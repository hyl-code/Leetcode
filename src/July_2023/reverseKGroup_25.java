package July_2023;

/*
    给你链表的头节点 head, 每 k 个节点一组进行翻转, 请你返回修改后的链表.
    k 是一个正整数, 它的值小于或等于链表的长度.
    如果节点总数不是 k 的整数倍, 那么请将最后剩余的节点保持原有顺序.
    你不能只是单纯的改变节点内部的值, 而是需要实际进行节点交换.
 */
public class reverseKGroup_25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode node = new ListNode(0);
        node.next = head;
        int len = 0;
        while(head != null){
            len++;
            head = head.next;
        }
        head = node.next;
        ListNode pre = node;
        ListNode cur = head;
        ListNode next;
        for(int i = 0; i < len / k; i++){
            for(int j = 0; j < k - 1; j++){
                next = cur.next;
                cur.next = next.next;
                next.next = pre.next;
                pre.next = next;
            }
            pre = cur;
            cur = pre.next;
        }
        return node.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
