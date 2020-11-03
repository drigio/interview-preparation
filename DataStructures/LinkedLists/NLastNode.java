/**
 * Given the head of a linked list, remove the nth node from the end of the list
 * and return its head. Follow up: Could you do this in one pass?
 * 
 * LeetCode :- https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */

public class NLastNode {
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
        int[] list1 = { 1, 2, 3, 4, 5 };
        int n = 2;

        ListNode l1 = null;

        for (int i = list1.length - 1; i >= 0; --i) {
            ListNode temp = new ListNode(list1[i]);
            temp.next = l1;
            l1 = temp;
        }

        ListNode res = removeNthFromEnd(l1, n);

        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null && n == 1)
            return null;

        ListNode first = head, second = head;
        while (second != null && n != 0) {
            second = second.next;
            n--;
        }

        while (second != null && second.next != null) {
            first = first.next;
            second = second.next;
        }

        if (first == head & second == null)
            return first.next;

        first.next = first.next.next;

        return head;
    }
}
