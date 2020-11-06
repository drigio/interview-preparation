public class QueueLinkedList {

    static class Queue<T> {
        class ListNode {
            T val;
            ListNode next;

            ListNode() {
            }

            ListNode(T val) {
                this.val = val;
            }

            ListNode(T val, ListNode next) {
                this.val = val;
                this.next = next;
            }
        }

        ListNode front, rear;

        Queue() {
            front = rear = null;
        }

        void enqueue(T data) {
            ListNode temp = new ListNode(data);
            if (isEmpty()) {
                front = rear = temp;
            }
            rear.next = temp;
            rear = temp;
        }

        T dequeue() {
            if (isEmpty()) {
                System.out.println("Queue Empty");
                return null;
            }
            T data = front.val;
            if (front == rear) {
                front = rear = null;
                return data;
            }
            front = front.next;
            return data;
        }

        boolean isEmpty() {
            return front == null;
        }

        T peek() {
            if (isEmpty()) {
                System.out.println("Queue Empty");
                return null;
            }
            return front.val;
        }

        void print() {
            if (isEmpty()) {
                System.out.println("Queue Empty");
                return;
            }
            ListNode ptr = front;
            System.out.print("FRONT -> ");
            while (ptr != rear) {
                System.out.print(ptr.val + " -> ");
                ptr = ptr.next;
            }
            System.out.println(ptr.val + " -> REAR");
        }
    }

    public static void main(String args[]) {
        Queue<Integer> q = new Queue<Integer>();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.print();

        q.dequeue();
        q.dequeue();
        q.dequeue();
        // q.dequeue();
        q.enqueue(30);
        q.enqueue(50);
        q.enqueue(80);
        q.print();
    }
}
