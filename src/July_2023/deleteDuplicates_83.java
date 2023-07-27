package July_2023;

import java.util.HashSet;
import java.util.Set;

public class deleteDuplicates_83 {
    // 递归
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        head.next = deleteDuplicates(head.next);
        // 去重
        if(head.val == head.next.val){
            head = head.next;
        }
        return head;
    }

    // Set + Pre 指针
    public ListNode deleteDuplicates1(ListNode head) {
        Set<Integer> set = new HashSet<>();
        ListNode node = head;
        ListNode pre = null;
        while(node != null){
            if(!set.add(node.val)){
                pre.next = node.next;
            }else{
                pre = node;
            }
            node = node.next;
        }
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
