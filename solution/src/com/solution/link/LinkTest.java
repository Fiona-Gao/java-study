package com.solution.link;

public class LinkTest {
    /*
    反向翻转 https://leetcode.cn/problems/reverse-linked-list/submissions/
     */
    public ListNode reverseList(ListNode head) {
        ListNode last = null;
        ListNode n = null;
        while (head != null) {
            n = head.next;
            head.next = last;
            last = head;
            head = n;
        }
        return last;
    }
    /*
    分组翻转 https://leetcode.cn/problems/reverse-nodes-in-k-group/submissions/
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // 1.分组
        ListNode protectNode = new ListNode(0, null);
        ListNode last = protectNode;
        while (head != null){
            // 分组
            ListNode end = getEnd(head, k);
            if (end == null) break;
            ListNode nextGroupHead = end.next;
            // 2.翻转
            revertKGroup(head, nextGroupHead);
            // 3.拼接
            last.next = end;
            head.next = nextGroupHead;
            last = head;
            head = nextGroupHead;
        }
        return protectNode.next;
    }
    public ListNode getEnd(ListNode head, int k) {
        while ( head != null){
            k --;
            if (k == 0) return head;
            head = head.next;
        }
        return null;
    }

    public void revertKGroup(ListNode head, ListNode end) {
        ListNode last = null;
        while (head != end) {
            ListNode n = head.next;
            head.next = last;
            last = head;
            head = n;
        }
    }

    /*
    快慢指针：https://leetcode.cn/problems/linked-list-cycle/submissions/
     */
    public boolean hasCycle(ListNode head) {
        if (head == null) {return false;}
        ListNode node = head;
        while (head != null && node != null){
            head = head.next;
            if (node.next == null) {
                return false;
            }
            node = node.next.next;
            if (head == node) {
                return true;
            }
        }
        return false;
    }
/*
 合并有序链表 https://leetcode.cn/problems/merge-two-sorted-lists/submissions/
 */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0, null);
        ListNode index = head;

        while (list1 != null || list2 != null){
            if (list2 == null || (list1 !=null && list1.val <= list2.val)){
                index.next = list1;
                list1 = list1.next;
            } else{
                index.next = list2;
                list2 = list2.next;
            }
            index = index.next;
        }
        return head.next;
    }

}

