package StackLinkedList;

public class StackLinkedList<T> {

    class ListNode {
        T data;
        ListNode next;

        public ListNode(T data) {
            this.data = data;
            this.next = null;
        }

        public ListNode() {
        }
    }

    ListNode top;
    int length;

    public StackLinkedList() {
        length = 0;
    }

    public void push(T data) {
        ListNode temp = new ListNode(data);
        temp.next = top;
        top = temp;
        length++;
    }

    public T pop() {
        if (isEmpty())
            return null;
        T data = top.data;
        top = top.next;
        length--;
        return data;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public void print() {
        ListNode temp = this.top;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");

    }

}