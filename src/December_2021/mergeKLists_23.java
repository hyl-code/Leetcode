package December_2021;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
    给你一个链表, 两两交换其中相邻的节点, 并返回交换后链表的头节点 .
    你必须在不修改节点内部的值的情况下完成本题 (即,只能进行节点交换) .
 */

public class mergeKLists_23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0 || lists == null)
            return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1, ListNode o2){
                if(o1.val < o2.val)
                    return -1;
                else if(o1.val == o2.val)
                    return 0;
                else
                    return 1;
            }
        });
        ListNode res = new ListNode(0);
        ListNode p = res;
        for(ListNode node : lists){
            if(node != null){
                queue.add(node);
            }
        }
        while(!queue.isEmpty()){
            p.next = queue.poll();
            p = p.next;
            if(p.next != null)
                queue.add(p.next);
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


