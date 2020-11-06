public class DequeLinkedList {

    static class MyCircularDeque {

        class LinkedNode {
            int data;
            LinkedNode next;

            LinkedNode(int data) {
                this.data = data;
                this.next = null;
            }
        }

        LinkedNode front, rear;
        int size;

        /** Initialize your data structure here. Set the size of the deque to be k. */
        public MyCircularDeque(int k) {
            front = rear = null;
            size = k;
        }

        /**
         * Adds an item at the front of Deque. Return true if the operation is
         * successful.
         */
        public boolean insertFront(int value) {
            if (isFull())
                return false;
            LinkedNode temp = new LinkedNode(value);
            size--;
            if (isEmpty()) {
                front = rear = temp;
                return true;
            }
            temp.next = front;
            front = temp;
            return true;
        }

        /**
         * Adds an item at the rear of Deque. Return true if the operation is
         * successful.
         */
        public boolean insertLast(int value) {
            if (isFull())
                return false;
            LinkedNode temp = new LinkedNode(value);
            size--;
            if (isEmpty()) {
                front = rear = temp;
                return true;
            }
            rear.next = temp;
            rear = temp;
            return true;
        }

        /**
         * Deletes an item from the front of Deque. Return true if the operation is
         * successful.
         */
        public boolean deleteFront() {
            if (isEmpty())
                return false;
            size++;
            if (front == rear) {
                front = rear = null;
                return true;
            }
            front = front.next;
            return true;
        }

        /**
         * Deletes an item from the rear of Deque. Return true if the operation is
         * successful.
         */
        public boolean deleteLast() {
            if (isEmpty())
                return false;
            size++;
            if (front == rear) {
                front = rear = null;
                return true;
            }
            LinkedNode temp = front;
            while (temp.next != rear)
                temp = temp.next;
            temp.next = null;
            rear = temp;
            return true;
        }

        /** Get the front item from the deque. */
        public int getFront() {
            if (isEmpty())
                return -1;
            return front.data;
        }

        /** Get the last item from the deque. */
        public int getRear() {
            if (isEmpty())
                return -1;
            return rear.data;
        }

        /** Checks whether the circular deque is empty or not. */
        public boolean isEmpty() {
            return front == null && rear == null;
        }

        /** Checks whether the circular deque is full or not. */
        public boolean isFull() {
            return size == 0;
        }
    }

    public static void main(String args[]) {
        MyCircularDeque circularDeque = new MyCircularDeque(3); // set the size to be 3
        System.out.println(circularDeque.insertLast(1)); // return true
        System.out.println(circularDeque.insertLast(2)); // return true
        System.out.println(circularDeque.insertFront(3)); // return true
        System.out.println(circularDeque.insertFront(4)); // return false, the queue is full
        System.out.println(circularDeque.getRear()); // return 2
        System.out.println(circularDeque.isFull()); // return true
        System.out.println(circularDeque.deleteLast()); // return true
        System.out.println(circularDeque.insertFront(4)); // return true
        System.out.println(circularDeque.getFront()); // return 4
    }
}
