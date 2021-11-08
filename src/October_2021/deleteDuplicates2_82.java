package October_2021;

/*
    存在一个按升序排列的链表, 给你这个链表的头节点 head ,
    请你删除链表中所有存在数字重复情况的节点, 只保留原始链表中没有重复出现的数字 .
    返回同样按升序排列的结果链表 .
 */

public class deleteDuplicates2_82 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode temp = head.next;
        if(head.val == temp.val){
            while(temp != null && head.val == temp.val){
                temp = temp.next;
            }
            head = deleteDuplicates(temp);
        }else{
            head.next = deleteDuplicates(temp);
        }
        return head;
    }
}
