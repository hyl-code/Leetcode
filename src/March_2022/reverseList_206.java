package March_2022;

/*
    给你单链表的头节点 head , 请你反转链表, 并返回反转后的链表 .
 */

public class reverseList_206 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    //迭代法
    public ListNode reverseList(ListNode head) {
        ListNode res = null;
        ListNode temp = head;
        while(temp != null){
            ListNode next = temp.next;
            temp.next = res;
            res = temp;
            temp = next;
        }
        return res;
    }
}
