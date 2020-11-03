# LinkedList

## Types

1. Singly Linked List
2. Doubly Linked List
3. Circular Linked List

## Major Problems

1. Merge Sorted Linked Lists. [Link]("./MergeSortedLinkedLists.java")
2. Return / Delete the Nth Last Node. [Link]("./NLastNode.java")
3. Cycle Detection in Linked List. [Link]("CycleDetection.java")

## Java Collections for LinkedList Implementations

### LinkedList<E>

[JDK 11 Docs](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/LinkedList.html)

- Doubly linked list implementation.
- Traversing the list by `get()` finds the element by head or tail whichever is closer to the index.
- This is not a synchronized implementation and is not thread safe in multi threaded environments, except for custom resource locks.
- It can also be used as a `Deque`.
