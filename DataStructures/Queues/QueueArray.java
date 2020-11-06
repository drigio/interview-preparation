public class QueueArray {

    static class Queue<T> {
        T[] list;
        int front, rear;
        int size = 10;

        Queue() {
            list = (T[]) new Object[size];
            front = rear = -1;
        }

        void enqueue(T data) {
            if (isEmpty()) {
                list[0] = data;
                front = rear = 0;
                return;
            }
            if (rear + 1 != front) {
                rear = (rear + 1) % size;
                list[rear] = data;
            } else {
                System.out.println("Queue Full");
            }
        }

        T dequeue() {
            if (isEmpty()) {
                System.out.println("Queue Empty");
                return null;
            }
            T data = list[front];
            if (front == rear) {
                front = rear = -1;
                return data;
            }
            front = (front + 1) % size;
            return data;
        }

        boolean isEmpty() {
            return front == -1;
        }

        void print() {
            if (isEmpty()) {
                System.out.println("Queue Empty");
                return;
            }
            int ptr = front;
            System.out.print("FRONT -> ");
            while (ptr != rear) {
                System.out.print(list[ptr] + " -> ");
                ptr = (ptr + 1) % size;
            }
            System.out.println(list[ptr] + " -> REAR");
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
