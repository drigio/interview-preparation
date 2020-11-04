package StackArray;

import java.util.ArrayList;

public class StackArray<T> {
    ArrayList<T> list;
    int top;

    public StackArray() {
        list = new ArrayList<T>();
        top = -1;
    }

    public boolean isEmpty() {
        return top < 0;
    }

    public void push(T data) {
        list.add(data);
        top++;
    }

    public T pop() {
        if (isEmpty())
            return null;
        T data = list.remove(top);
        top--;
        return data;
    }

    public void print() {
        for (int i = top; i >= 0; --i)
            System.out.print(list.get(i) + " -> ");
        System.out.println("NULL");
    }

}
