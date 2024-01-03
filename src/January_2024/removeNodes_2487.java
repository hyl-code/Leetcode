package January_2024;

/*
    给你一个链表的头节点 head.
    移除每个右侧有一个更大数值的节点.
    返回修改后链表的头节点 head.
 */
public class removeNodes_2487 {
    public ListNode removeNodes(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        head = reverseList(head);
        ListNode cur = head;
        ListNode next = cur.next;
        while(next != null){
            if(cur.val > next.val){
                ListNode tmp = next.next;
                cur.next = tmp;
                next.next = null;
                next = tmp;
            }else{
                cur = next;
                next = next.next;
            }
        }
        head = reverseList(head);
        return head;
    }

    private ListNode reverseList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode pre = head.next;
        ListNode next = pre.next;
        head.next = null;
        while(next != null){
            pre.next = head;
            head = pre;
            pre = next;
            next = next.next;
        }
        pre.next = head;
        head = pre;
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
