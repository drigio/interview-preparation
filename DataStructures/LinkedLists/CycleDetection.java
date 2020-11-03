/**
 * Given head, the head of a linked list, determine if the linked list has a
 * cycle in it.
 * 
 * There is a cycle in a linked list if there is some node in the list that can
 * be reached again by continuously following the next pointer. Internally, pos
 * is used to denote the index of the node that tail's next pointer is connected
 * to. Note that pos is not passed as a parameter.
 * 
 * Return true if there is a cycle in the linked list. Otherwise, return false
 * 
 * LeetCode :- https://leetcode.com/problems/linked-list-cycle/
 */

public class CycleDetection {
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
        int[] list1 = { 3, 2, 0, -4 };

        ListNode l1 = null;

        for (int i = list1.length - 1; i >= 0; --i) {
            ListNode temp = new ListNode(list1[i]);
            temp.next = l1;
            l1 = temp;
        }

        /**
         * Creating artificial cycle. Comment out to remove cycle
         */
        l1.next.next.next.next = l1.next;

        System.out.println(hasCycle(l1));

    }

    public static boolean hasCycle(ListNode head) {

        if (head == null)
            return false;

        ListNode slow = head, fast = head.next;

        while (fast != null && fast.next != null && slow != null) {
            if (fast == slow)
                return true;
            fast = fast.next.next;
            slow = slow.next;
        }

        return false;

    }
}
