package HeapImp;

public class HeapArrayImp {
    int[] heap;
    int size, capacity;

    public HeapArrayImp(int c) {
        capacity = c;
        heap = new int[capacity + 1];
        size = 0;
        heap[0] = Integer.MAX_VALUE;
    }

    public void push(int e) {
        if (size == capacity) {
            incrementCapacity(capacity * 2);
        }
        int currentNode = ++size;
        while (currentNode != 1 && heap[currentNode / 2] < e) {
            heap[currentNode] = heap[currentNode / 2];
            currentNode /= 2;
        }
        heap[currentNode] = e;
    }

    public int pop() {
        if (isEmpty()) {
            return Integer.MIN_VALUE;
        }
        int temp = heap[1], lastNode = heap[size--];
        int currentNode = 1, child = 2;
        while (child <= size) {
            if (child < size && heap[child] <= heap[child + 1])
                child++;
            if (lastNode >= heap[child])
                break;
            heap[currentNode] = heap[child];
            currentNode = child;
            child *= 2;
        }
        heap[currentNode] = lastNode;
        return temp;
    }

    public void print() {
        for (int i = 1; i <= size; ++i) {
            System.out.print(heap[i] + " -> ");
        }
        System.out.println("End. Size = " + size + " Capacity = " + capacity);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int top() {
        if (isEmpty())
            return Integer.MIN_VALUE;
        return heap[1];
    }

    void incrementCapacity(int newCapacity) {
        int[] newHeap = new int[newCapacity];
        System.arraycopy(this.heap, 0, newHeap, 0, this.heap.length);
        this.heap = newHeap;
        this.capacity = newCapacity;
    }
}