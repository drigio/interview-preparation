
/**
 * Implement a first in first out (FIFO) queue using only two stacks. 
 * The implemented queue should support all the functions of a normal queue.
 * 
 * LeetCode :- https://leetcode.com/problems/implement-queue-using-stacks/
 */

import java.util.Stack;

public class QueueStack {
    static class MyQueue {
        Stack<Integer> stack1, stack2;

        /** Initialize your data structure here. */
        public MyQueue() {
            stack1 = new Stack<Integer>();
            stack2 = new Stack<Integer>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
            stack1.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }

        /** Get the front element. */
        public int peek() {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return stack1.isEmpty() && stack2.isEmpty();
        }
    }

    public static void main(String args[]) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        System.out.println(myQueue.peek()); // return 1
        System.out.println(myQueue.pop());// return 1, queue is [2]
        System.out.println(myQueue.empty()); // return false
    }
}
