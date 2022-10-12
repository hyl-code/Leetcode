package October_2022;

import java.util.HashSet;
import java.util.Set;

/*
    给定链表头结点 head, 该链表上的每个结点都有一个唯一的整型值.
    同时给定列表 nums, 该列表是上述链表中整型值的一个子集.
    返回列表 nums 中组件的个数, 这里对组件的定义为: 链表中一段最长连续结点的值(该值必须在列表 nums 中)构成的集合.
 */

public class numComponents_817 {
    public int numComponents(ListNode head, int[] nums) {
        if(head == null){
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        ListNode node = head;
        int res = 0;
        while(node != null){
            //判断是否为组件尾端
            if(set.contains(node.val) && (node.next == null || !set.contains(node.next.val))){
                res++;
            }
            node = node.next;
        }
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
