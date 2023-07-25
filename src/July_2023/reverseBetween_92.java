package July_2023;

/*
    给你单链表的头指针 head 和两个整数 left 和 right, 其中 left <= right.
    请你反转从位置 left 到位置 right 的链表节点, 返回反转后的链表.
 */
public class reverseBetween_92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode pre = node;
        // 定位
        for(int i = 1; i < left; i++){
            pre = pre.next;
        }
        head = pre.next;
        // 调整
        for(int i = left; i < right; i++){
            ListNode temp = head.next;
            head.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
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
