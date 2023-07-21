package July_2023;

/*
    给你一个链表的头节点 head, 旋转链表, 将链表每个节点向右移动 k 个位置.
 */
public class rotateRight_61 {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0){
            return head;
        }
        int cnt = 1;
        ListNode node = head;
        while(node.next != null){
            cnt++;
            node = node.next;
        }
        k %= cnt;
        if(k == 0){
            return head;
        }
        // 形成闭环
        node.next = head;
        //找到倒数第 n - k 个结点, 该结点为新链表的头结点.
        for(int i = 0; i < cnt - k; i++){
            node = node.next;
        }
        ListNode res = node.next;
        // 将闭环断开
        node.next = null;
        return res;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
