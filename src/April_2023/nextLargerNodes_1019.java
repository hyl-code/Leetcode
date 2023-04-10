package April_2023;

import java.util.ArrayList;
import java.util.Stack;

/*
    给定一个长度为 n 的链表 head
    对于列表中的每个节点, 查找下一个更大节点的值.
    也就是说, 对于每个节点, 找到它旁边的第一个节点的值, 这个节点的值严格大于它的值.
    返回一个整数数组 answer, 其中 answer[i] 是第 i 个节点 (从1开始) 的下一个更大的节点的值.
    如果第 i 个节点没有下一个更大的节点, 设置 answer[i] = 0 .
 */
public class nextLargerNodes_1019 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public int[] nextLargerNodes(ListNode head) {
        if(head == null){
            return null;
        }
        ArrayList<Integer> list = new ArrayList<>();
        int n = 0;
        while(head != null){
            list.add(head.val);
            n++;
            head = head.next;
        }
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[n];
        // 题意要求找到该节点往后的最大节点, 因此从后向前循环
        for(int i = n - 1; i >= 0; i--){
            // 小于等于该节点 val 时, 栈 pop 后, 栈顶仍是该节点右侧最大节点.
            while(!stack.empty() && stack.peek() <= list.get(i)){
                stack.pop();
            }
            res[i] = stack.empty() ? 0 : stack.peek();
            stack.push(list.get(i));
        }
        return res;
    }
}
