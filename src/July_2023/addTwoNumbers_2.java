package July_2023;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

/*
    给你两个非空的链表, 表示两个非负的整数. 它们每位数字都是按照逆序的方式存储的, 并且每个节点只能存储一位数字.
    请你将两个数相加, 并以相同形式返回一个表示和的链表.
    你可以假设除了数字 0 之外, 这两个数都不会以 0 开头.
 */
public class addTwoNumbers_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode node = res;
        int carry = 0;  // 进位
        while(l1 != null || l2 != null || carry != 0){
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;
            int sumVal = val1 + val2 + carry;
            carry = sumVal / 10;
            ListNode sum = new ListNode(sumVal % 10);
            node.next = sum;
            node = node.next;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
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
