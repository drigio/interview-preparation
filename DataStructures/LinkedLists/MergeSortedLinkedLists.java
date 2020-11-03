
/**
 * Merge Two Sorted Lists
 * 
 * Problem :- Merge two sorted linked lists and return it as a new sorted list.
 * The new list should be made by splicing together the nodes of the first two
 * lists.
 * 
 * LeetCode :- https://leetcode.com/problems/merge-two-sorted-lists/
 */

public class MergeSortedLinkedLists {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String args[]) {

        // ADD INPUTS HERE
        int[] list1 = { 1, 2, 4 };
        int[] list2 = { 1, 3, 4 };

        ListNode l1 = null, l2 = null;

        for (int i = list1.length - 1; i >= 0; --i) {
            ListNode temp = new ListNode(list1[i]);
            temp.next = l1;
            l1 = temp;
        }

        for (int i = list2.length - 1; i >= 0; --i) {
            ListNode temp = new ListNode(list2[i]);
            temp.next = l2;
            l2 = temp;
        }

        ListNode merged = mergeTwoLists(l1, l2);

        while (merged != null) {
            System.out.print(merged.val + " ");
            merged = merged.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        ListNode node = new ListNode();
        ListNode ptr = node;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                node.next = l1;
                l1 = l1.next;
            } else {
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }

        while (l1 != null) {
            node.next = l1;
            l1 = l1.next;
            node = node.next;
        }

        while (l2 != null) {
            node.next = l2;
            l2 = l2.next;
            node = node.next;
        }

        return ptr.next;
    }

}
