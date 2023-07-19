package July_2023;

/*
    将两个升序链表合并为一个新的升序链表并返回.
    新链表是通过拼接给定的两个链表的所有节点组成的.
 */
public class mergeTwoLists_21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        ListNode res = new ListNode(0);
        if(list1.val < list2.val){
            res.next = list1;
            res.next.next = mergeTwoLists(list1.next, list2);
        }else{
            res.next = list2;
            res.next.next = mergeTwoLists(list1, list2.next);
        }
        return res.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
