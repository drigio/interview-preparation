package TreeImplementation;

public class Tree {
    class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
            this.left = this.right = null;
        }

        TreeNode() {
            this.left = this.right = null;
        }
    }

    TreeNode root;

    public Tree() {
        root = null;
    }

    public void add(int data) {
        root = addRec(root, data);
    }

    TreeNode addRec(TreeNode node, int data) {
        if (node == null) {
            node = new TreeNode(data);
            return node;
        }
        if (data < node.data) {
            node.left = addRec(node.left, data);
        } else if (data > node.data) {
            node.right = addRec(node.right, data);
        }
        return node;
    }

    public void delete(int data) {
        root = deleteRec(root, data);
    }

    TreeNode deleteRec(TreeNode node, int data) {
        if (node == null)
            return node;
        if (data < node.data) {
            node.left = deleteRec(node.left, data);
        } else if (data > node.data) {
            node.right = deleteRec(node.right, data);
        } else {
            if (node.left == null)
                return node.right;
            else if (node.right == null)
                return node.left;

            node.data = minRec(node.right);
            node.right = deleteRec(node.right, node.data);
        }
        return node;
    }

    public int min() {
        return minRec(root);
    }

    int minRec(TreeNode node) {
        if (node == null)
            return -1;
        while (node.left != null)
            node = node.left;
        return node.data;
    }

    public int max() {
        return maxRec(root);
    }

    int maxRec(TreeNode node) {
        if (node == null)
            return -1;
        while (node.right != null)
            node = node.right;
        return node.data;
    }

    public void preOrder() {
        preOrderRec(root);
    }

    void preOrderRec(TreeNode node) {
        if (node == null)
            return;
        System.out.print(node.data + " -> ");
        preOrderRec(node.left);
        preOrderRec(node.right);
    }

    public void inOrder() {
        inOrderRec(root);
    }

    void inOrderRec(TreeNode node) {
        if (node == null)
            return;
        inOrderRec(node.left);
        System.out.print(node.data + " -> ");
        inOrderRec(node.right);
    }

    public void postOrder() {
        postOrderRec(root);
    }

    void postOrderRec(TreeNode node) {
        if (node == null)
            return;
        postOrderRec(node.left);
        postOrderRec(node.right);
        System.out.print(node.data + " -> ");
    }

    public int height() {
        return heightRec(root);
    }

    int heightRec(TreeNode node) {
        if (node == null)
            return -1;
        int lh = heightRec(node.left);
        int rh = heightRec(node.right);
        return lh > rh ? lh + 1 : rh + 1;
    }

    public int size() {
        return sizeRec(root);
    }

    int sizeRec(TreeNode node) {
        if (node == null)
            return 0;
        return sizeRec(node.left) + sizeRec(node.right) + 1;
    }
}
