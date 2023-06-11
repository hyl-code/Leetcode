package June_2023;

import java.util.HashMap;
import java.util.Map;

public class removeZeroSumSublists_1171 {
    //递归
    public ListNode removeZeroSumSublists(ListNode head) {
        if(head == null){
            return null;
        }
        int sum = 0;
        for(ListNode node = head; node != null; node = node.next){
            sum += node.val;
            //前 n 个都为 0 的情况下, 可以直接把前面的节点全部忽略
            if(sum == 0){
                return removeZeroSumSublists(node.next);
            }
        }
        //依次递归
        head.next = removeZeroSumSublists(head.next);
        return head;
    }

    // HashMap + 前缀和
    public ListNode removeZeroSumSublists2(ListNode head) {
        //简化代码, 处理头节点被删去的情况
        ListNode pre = new ListNode(0);
        pre.next = head;
        Map<Integer, ListNode> map = new HashMap<>();
        int prefix = 0;
        //计算前缀和
        for(ListNode node = pre; node != null; node = node.next){
            prefix += node.val;
            map.put(prefix, node);
        }
        prefix = 0;
        //中间跳过部分总和为 0.
        for(ListNode node = pre; node != null; node = node.next){
            prefix += node.val;
            node.next = map.get(prefix).next;
        }
        return pre.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
