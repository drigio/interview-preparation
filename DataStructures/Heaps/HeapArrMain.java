import HeapImp.HeapArrayImp;

public class HeapArrMain {
    public static void main(String args[]) {
        HeapArrayImp heap = new HeapArrayImp(4);
        heap.push(10);
        heap.push(7);
        heap.push(8);
        heap.push(4);

        System.out.println("Before capacity full");
        heap.print();

        heap.push(3);
        heap.push(2);
        heap.push(6);

        System.out.println("After capacity full and few pushes");
        heap.print();

        System.out.println("After popping out.");
        heap.pop();
        heap.print();

        System.out.println("Current top element is " + heap.top());

    }
}
