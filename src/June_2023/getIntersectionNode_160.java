package June_2023;
/*
    给你两个单链表的头节点 headA 和 headB, 请你找出并返回两个单链表相交的起始节点.
    如果两个链表不存在相交节点, 返回 null.
    题目数据保证整个链式结构中不存在环.
    注意, 函数返回结果后，链表必须 保持其原始结构.
 */
public class getIntersectionNode_160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode pA = headA, pB = headB;
        // pA 第一次到达尾部时移向 headB 表头, pB 同理
        // 若 headA 和 headB 相交, 则 pA 和 pB 相交时, pA 和 pB 移动了相同的距离
        while(pA != pB){
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
