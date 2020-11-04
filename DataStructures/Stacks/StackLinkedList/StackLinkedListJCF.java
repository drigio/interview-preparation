package StackLinkedList;

import java.util.LinkedList;
import java.util.ListIterator;

public class StackLinkedListJCF<T> {
    LinkedList<T> list;
    int length;

    public StackLinkedListJCF() {
        list = new LinkedList<T>();
        length = 0;
    }

    public void push(T data) {
        list.addFirst(data);
        length++;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public T pop() {
        if (isEmpty())
            return null;
        length--;
        return list.removeFirst();
    }

    public void print() {
        ListIterator<T> i = list.listIterator();
        while (i.hasNext())
            System.out.print(i.next() + " -> ");
        System.out.println("NULL");

    }
}
