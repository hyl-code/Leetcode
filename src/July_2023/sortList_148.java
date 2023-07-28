package July_2023;

import java.util.Arrays;
/*
    给你链表的头结点 head, 请将其按升序排列并返回排序后的链表.
 */
public class sortList_148 {
    // 归并排序
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    private ListNode mergeSort(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next.next;
        ListNode left, right;
        // 快慢指针找出中位点
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // 对右半部分进行归并排序
        right = mergeSort(slow.next);
        // 链表判断结束的标志：末尾节点.next == null
        slow.next = null;
        // 对左半部分进行归并排序
        left = mergeSort(head);
        return mergeList(left, right);
    }

    // 合并链表
    private ListNode mergeList(ListNode left, ListNode right){
        ListNode temp = new ListNode(-1);
        ListNode node = temp;
        while(left != null && right != null){
            if(left.val < right.val){
                node.next = left;
                left = left.next;
            }else{
                node.next = right;
                right = right.next;
            }
            node = node.next;
        }
        node.next = left == null ? right : left;
        return temp.next;
    }

    // 有些暴力的方法
    public ListNode sortList2(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode node = head;
        int n = 0;
        while(node != null){
            node = node.next;
            n++;
        }
        node = head;
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = node.val;
            node = node.next;
        }
        Arrays.sort(arr);
        node = head;
        for(int i = 0; i < n; i++){
            node.val = arr[i];
            node = node.next;
        }
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
