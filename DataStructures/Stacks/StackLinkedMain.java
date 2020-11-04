import StackLinkedList.StackLinkedList;
import StackLinkedList.StackLinkedListJCF;
import StackArray.StackArray;

public class StackLinkedMain {
    public static void main(String args[]) {
        StackLinkedList<Integer> stack = new StackLinkedList<Integer>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        stack.pop();
        stack.pop();
        stack.print();

        StackLinkedListJCF<Integer> stk = new StackLinkedListJCF<Integer>();
        stk.push(10);
        stk.push(20);
        stk.push(30);
        stk.push(40);

        stk.pop();
        stk.pop();
        stk.print();

        StackArray<Integer> stac = new StackArray<Integer>();
        stac.push(10);
        stac.push(20);
        stac.push(30);
        stac.push(40);

        stac.pop();
        stac.pop();
        stac.print();

    }
}
