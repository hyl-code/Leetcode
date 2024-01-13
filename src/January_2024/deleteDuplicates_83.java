package January_2024;

import java.util.HashSet;
import java.util.Set;
/*
    给定一个已排序的链表的头 head, 删除所有重复的元素, 使每个元素只出现一次.
    返回已排序的链表.
 */
public class deleteDuplicates_83 {
    public ListNode deleteDuplicates(ListNode head) {
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
