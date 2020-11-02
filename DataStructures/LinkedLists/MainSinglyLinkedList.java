import SinglyLinkedListsPkg.LinkedList;

class MainSinglyLinkedList {
    public static void main(String args[]) {
        LinkedList<Integer> list = new LinkedList<Integer>(20);
        list.insertAtEnd(30);
        list.insertAtEnd(50);
        list.insertFront(10);
        list.insertKey(40, 30);
        list.insertKey(60, 40);
        list.print();

        list.deleteFront();
        list.deleteKey(40);
        list.deleteEnd();
        list.print();

        list.mergeList(new LinkedList<Integer>(60));
        list.print();

        list.reverse();
        list.print();

        System.out.println("Done");
    }
}
