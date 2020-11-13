import TreeImplementation.Tree;

class TreeMain {
    public static void main(String args[]) {
        Tree tree = new Tree();
        tree.add(30);
        tree.add(20);
        tree.add(10);
        tree.add(80);
        tree.add(90);
        tree.add(60);
        tree.add(50);

        tree.delete(90);
        tree.delete(30);

        System.out.println("InOrder Traversal :- ");

        tree.inOrder();

        System.out.println();

        System.out.println("Minimum Element is " + tree.min());

        System.out.println("Maximum Element is " + tree.max());

        System.out.println("Height of Tree is " + tree.height());

        System.out.println("Size of Tree is " + tree.size());

        System.out.println("PreOrder Traversal :- ");
        tree.preOrder();
        System.out.println();

        System.out.println("PostOrder Traversal :- ");
        tree.postOrder();

    }
}
