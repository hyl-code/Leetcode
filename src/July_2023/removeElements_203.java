package July_2023;

/*
    给你一个链表的头节点 head 和一个整数 val, 请你删除链表中所有满足 Node.val == val 的节点, 并返回新的头节点.
 */
public class removeElements_203 {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return null;
        }
        ListNode node = new ListNode(-1);
        node.next = head;
        ListNode temp = node;
        while(temp.next != null){
            if(temp.next.val == val){
                temp.next = temp.next.next;
            }else{
                temp = temp.next;
            }
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
