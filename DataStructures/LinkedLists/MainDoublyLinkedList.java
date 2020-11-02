import DoublyLinkedListPkg.LinkedList;

class MainDoublyLinkedList {
    public static void main(String args[]) {
        LinkedList<Integer> list = new LinkedList<Integer>(20);
        list.insertEnd(30);
        list.insertEnd(50);
        list.insertFront(10);
        list.insertKey(40, 30);
        list.insertKey(60, 40);
        list.print();

        list.deleteFront();
        list.deleteKey(40);
        list.deleteEnd();
        list.print();

        list.reverse();
        list.print();

        System.out.println("Done");
    }
}
