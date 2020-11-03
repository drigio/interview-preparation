package SinglyLinkedListsPkg;

public class LinkedList<T> {
    ListNode head;

    public LinkedList(T data) {
        this.head = new ListNode(data);
    }

    public LinkedList() {
        this.head = new ListNode();
    }

    public ListNode getHead() {
        return this.head;
    }

    public void insertAtEnd(T n) {
        ListNode node = head;
        ListNode temp = new ListNode(n);
        temp.next = null;
        if (node == null) {
            head = temp;
            return;
        }
        while (node.next != null)
            node = node.next;
        node.next = temp;
    }

    public void insertFront(T n) {
        ListNode temp = new ListNode(n);
        temp.next = head;
        head = temp;
    }

    public boolean insertKey(T n, T key) {
        ListNode node = new ListNode(n);
        if (head == null) {
            head = node;
            return true;
        }
        ListNode temp = head;
        while (temp != null && temp.data != key)
            temp = temp.next;
        node.next = temp.next;
        temp.next = node;
        return true;
    }

    public T deleteFront() {
        T data = null;
        if (head != null)
            data = head.data;
        head = head.next;
        return data;
    }

    public T deleteEnd() {
        if (head == null)
            return null;
        T data = null;
        if (head.next == null) {
            data = head.data;
            head = null;
            return data;
        }
        ListNode temp = head;
        while (temp.next != null && temp.next.next != null)
            temp = temp.next;
        data = temp.next.data;
        temp.next = null;
        return data;
    }

    public T deleteKey(T key) {
        if (head == null)
            return null;
        if (head.next == null && head.data == key) {
            T data = head.data;
            head = null;
            return data;
        }
        ListNode temp = head;
        while (temp.next != null && temp.next.data != key)
            temp = temp.next;
        T data = temp.next.data;
        temp.next = temp.next.next;
        return data;
    }

    public void mergeList(LinkedList<T> list) {
        if (head == null)
            head = list.head;
        ListNode temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = list.head;
    }

    void recursiveReverse(ListNode cur, ListNode prev) {
        if (cur.next == null) {
            cur.next = prev;
            head = cur;
            return;
        }
        recursiveReverse(cur.next, cur);
        cur.next = prev;
    }

    public void reverse() {
        if (head == null || head.next == null)
            return;
        recursiveReverse(head, null);
    }

    public void print() {
        if (head == null) {
            System.out.println("List Empty.");
            return;
        }
        ListNode node = head;
        System.out.println("The List is ");
        while (node != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.println("NULL");
    }

    /**
     * insertbeg, insertkey, deletekey, deletefirst, deletelast, merge
     */

    public class ListNode {
        T data;
        ListNode next;

        public ListNode(T data) {
            this.data = data;
            this.next = null;
        }

        public ListNode() {
        }

        public T getData() {
            return this.data;
        }

        public ListNode getNext() {
            return this.next;
        }

        public void setData(T data) {
            this.data = data;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }
}