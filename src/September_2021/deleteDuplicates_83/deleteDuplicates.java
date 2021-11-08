package September_2021.deleteDuplicates_83;

/*
    存在一个按升序排列的链表, 给你这个链表的头节点 head ,
    请你删除所有重复的元素, 使每个元素只出现一次.
    返回同样按升序排列的结果链表
 */

public class deleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        head.next = deleteDuplicates(head.next);
        if(head.val == head.next.val){
            head = head.next;
        }
        return head;
    }
}
