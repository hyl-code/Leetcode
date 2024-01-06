package January_2024;

/*
    给你一个链表的头 head, 每个结点包含一个整数值.
    在相邻结点之间, 请你插入一个新的结点, 结点值为这两个相邻结点值的最大公约数.
    请你返回插入之后的链表.
    两个数的最大公约数是可以被两个数字整除的最大正整数.
 */
public class insertGreatestCommonDivisors_2807 {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode node = head;
        while(node.next != null){
            node.next = new ListNode(gcd(node.val, node.next.val), node.next);
            node = node.next.next;
        }
        return head;
    }

    public int gcd(int a, int b){
        while(b != 0){
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
