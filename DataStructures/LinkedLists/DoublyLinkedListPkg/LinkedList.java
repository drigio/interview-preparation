package DoublyLinkedListPkg;

public class LinkedList<T> {

    ListNode head;

    class ListNode {
        T data;
        ListNode next;
        ListNode prev;

        public ListNode(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public LinkedList(T data) {
        this.head = new ListNode(data);
    }

    public void insertFront(T data) {
        ListNode node = new ListNode(data);
        head.prev = node;
        node.next = head;
        head = node;
    }

    public void insertEnd(T data) {
        if (head == null) {
            head = new ListNode(data);
            return;
        }
        ListNode temp = head;
        while (temp.next != null)
            temp = temp.next;
        ListNode node = new ListNode(data);
        temp.next = node;
        node.prev = temp;
    }

    public boolean insertKey(T data, T key) {
        if (head == null)
            return false;
        if (head.next == null && head.data == key) {
            ListNode node = new ListNode(data);
            head.next = node;
            node.prev = head;
            return true;
        }
        ListNode temp = head;
        while (temp != null && temp.data != key) {
            temp = temp.next;
        }
        if (temp == null)
            return false;
        ListNode node = new ListNode(data);
        node.next = temp.next;
        node.prev = temp;
        node.next.prev = node;
        temp.next = node;
        return true;
    }

    public T deleteFront() {
        if (head == null)
            return null;
        T data = head.data;
        if (head.next == null) {
            head = null;
            return data;
        }
        head.next.prev = null;
        head = head.next;
        return data;
    }

    public T deleteEnd() {
        if (head == null)
            return null;
        T data = head.data;
        if (head.next == null) {
            head = null;
            return data;
        }
        ListNode temp = head;
        while (temp.next != null)
            temp = temp.next;
        data = temp.data;
        temp.prev.next = null;
        return data;
    }

    public T deleteKey(T key) {
        if (head == null)
            return null;
        if (head.next == null && head.data != key) {
            return null;
        }
        ListNode temp = head;
        while (temp != null && temp.data != key)
            temp = temp.next;

        if (temp == null)
            return null;

        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        return key;
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

    void recursiveReverse(ListNode cur) {
        if (cur.next == null) {
            cur.next = cur.prev;
            cur.prev = null;
            head = cur;
            return;
        }
        recursiveReverse(cur.next);
        ListNode next = cur.next;
        cur.next = cur.prev;
        cur.prev = next;
    }

    public void reverse() {
        if (head == null || head.next == null)
            return;
        recursiveReverse(head);
    }

}
