package October_2023;

import java.util.HashSet;
import java.util.Set;
/*
    给你一个链表的头节点 head, 判断链表中是否有环.
    如果链表中有某个节点, 可以通过连续跟踪 next 指针再次到达, 则链表中存在环.
    为了表示给定链表中的环, 评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）.
    注意：pos 不作为参数进行传递. 仅仅是为了标识链表的实际情况.
    如果链表中存在环, 则返回 true. 否则, 返回 false.
 */
public class hasCycle_141 {
    // 通过快慢指针判断
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    // 通过 Set 容器去判断
    public boolean hasCycle2(ListNode head) {
        Set<ListNode> set = new HashSet();
        while(head != null){
            if(!set.add(head)){
                return true;
            }
            head = head.next;
        }
        return false;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
          val = x;
          next = null;
        }
    }
}
