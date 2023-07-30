package July_2023;

import java.util.Random;
/*
    给你一个单链表, 随机选择链表的一个节点, 并返回相应的节点值. 每个节点被选中的概率一样.
    实现 Solution 类：
        Solution(ListNode head) 使用整数数组初始化对象.
        int getRandom() 从链表中随机选择一个节点并返回该节点的值. 链表中所有节点被选中的概率相等. 
 */
public class RandomList1_382 {
    ListNode head;
    Random r;
    public RandomList1_382(ListNode head) {
        this.head = head;
        this.r = new Random();
    }

    // 蓄水池算法, 无需数组, 直接在链表上操作
    /*
        当链表前行到第一个数字, 此时取第一个数字的几率为100% , 那result自然等于这个数字.
        前进到第二个数字, 那么此时取这个数字的几率自然就为50%（池子里只有两个数字）, 那么就是 50% 的几率取新数字, 50% 的几率保留原本的数字.
        第三个数字的时候, 33% 的几率取当前最新的这个数字, 66% 的几率保留原本的数字.
        这 66% 中：原本的数字有 50% 的几率是1，有 50% 的几率是2（也就是此时三个数字的概率都为 33% ）.
        通过这个算法, 就能达到取数的概率均摊, 从而实现随机.
     */
    public int getRandom() {
        ListNode node = this.head;
        int cnt = 0;
        int res = 0;
        while(node != null){
            cnt++;
            int rInt = r.nextInt(cnt) + 1;
            if(rInt == cnt){
                res = node.val;
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
