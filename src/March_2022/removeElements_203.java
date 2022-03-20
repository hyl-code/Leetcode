package March_2022;

/*
    给你一个链表的头节点 head 和一个整数 val, 请你删除链表中所有满足 Node.val == val 的节点, 并返回 新的头节点 .
 */

public class removeElements_203 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeElements(ListNode head, int val) {
        //设置头节点 避免前 n 个 node 值均为val .
        ListNode header = new ListNode(-1);
        header.next = head;
        ListNode temp = header;
        while(temp.next != null){
            if(temp.next.val == val){
                temp.next = temp.next.next;
            }else{
                temp = temp.next;
            }
        }
        return header.next;
    }
}
