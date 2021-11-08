package November_2021;

/*
    请编写一个函数, 用于删除单链表中某个特定节点 .
    在设计函数时需要注意, 你无法访问链表的头节点 head, 只能直接访问 要被删除的节点 .
    题目数据保证需要删除的节点不是末尾节点 .
 */

public class deleteNode_237 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
