class Node {
    int val;
    Node left, right;

    Node(int val) {
        this.val = val;
        left = right = null;
    }
}

public class BST {

    // 🔹 Recursive Insert
    static Node insert(Node root, int val) {
        if (root == null) {
            return new Node(val);
        }

        if (val < root.val) {
            root.left = insert(root.left, val);
        } else if (val > root.val) {
            root.right = insert(root.right, val);
        }

        return root;
    }

    // 🔹 Recursive Search
    static boolean search(Node root, int key) {
        if (root == null)
            return false;

        if (root.val == key)
            return true;

        if (key < root.val)
            return search(root.left, key);
        else
            return search(root.right, key);
    }

    // 🔹 Inorder Traversal
    static void inorder(Node root) {
        if (root == null)
            return;

        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {

        Node root = null;

        int[] values = {10, 5, 15, 2, 7, 12, 20};
        for (int v : values) {
            root = insert(root, v);
        }

        System.out.print("Inorder: ");
        inorder(root);
        System.out.println();

        int key = 7;
        System.out.println(
                search(root, key)
                        ? "Element found ✅"
                        : "Element not found ❌"
        );
    }
}