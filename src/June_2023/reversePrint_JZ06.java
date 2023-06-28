package June_2023;

import java.util.Stack;
/*
    输入一个链表的头节点, 从尾到头反过来返回每个节点的值（用数组返回）.
 */
public class reversePrint_JZ06 {
    // 反向插入
    public int[] reversePrint(ListNode head) {
        ListNode node = head;
        int cnt = 0;
        while(node != null){
            cnt++;
            node = node.next;
        }
        node = head;
        int[] res = new int[cnt];
        for(int i = cnt - 1; i >= 0; i--){
            res[i] = node.val;
            node = node.next;
        }
        return res;
    }

    // 栈
    public int[] reversePrint2(ListNode head) {
        Stack<Integer> stack = new Stack<Integer>();
        while(head != null){
            stack.push(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        for(int i = 0; !stack.isEmpty(); i++){
            res[i] = stack.pop();
        }
        return res;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
