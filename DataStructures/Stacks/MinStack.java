/**
 * Design a stack that supports push, pop, top, and retrieving the minimum
 * element in constant time.
 * 
 * push(x) -- Push element x onto stack. pop() -- Removes the element on top of
 * the stack. top() -- Get the top element. getMin() -- Retrieve the minimum
 * element in the stack.
 * 
 * LeetCode:- https://leetcode.com/problems/min-stack/
 */

public class MinStack {

    static class Stack {
        class ListNode {
            int data;
            ListNode next;

            ListNode(int data) {
                this.data = data;
                this.next = null;
            }
        }

        ListNode top;
        ListNode min;

        Stack() {
            top = null;
            min = null;
        }

        public void push(int x) {
            ListNode temp = new ListNode(x);
            temp.next = top;
            top = temp;
            if (top.next == null || min == null) {
                min = top;
            } else {
                if (top.data <= min.data) {
                    ListNode minTemp = new ListNode(top.data);
                    minTemp.next = min;
                    min = minTemp;
                }
            }
        }

        public void pop() {
            if (min.data == top.data) {
                min = min.next;
            }
            top = top.next;
        }

        public int top() {
            return top.data;
        }

        public int getMin() {
            return min.data;
        }
    }

    public static void main(String args[]) {
        Stack stk = new Stack();
        stk.push(-2);
        stk.push(0);
        stk.push(-3);
        System.out.println(stk.getMin()); // return -3
        stk.pop();
        stk.top(); // return 0
        System.out.println(stk.getMin()); // return -2
    }
}
