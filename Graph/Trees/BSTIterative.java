import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class BSTIterative {

    public static TreeNode insert(TreeNode root, int key) {
        if (root == null) {
            return new TreeNode(key);
        }

        TreeNode current = root;
        while (true) {
            if (key < current.val) {
                if (current.left == null) {
                    current.left = new TreeNode(key);
                    break;
                } else {
                    current = current.left;
                }
            } else if (key > current.val) {
                if (current.right == null) {
                    current.right = new TreeNode(key);
                    break;
                } else {
                    current = current.right;
                }
            } else {
                // Duplicate keys are not allowed in a BST
                break;
            }
        }

        return root;
    }

    public static void inOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            System.out.print(current.val + " ");

            current = current.right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = null;
        int[] keys = { 5, 3, 8, 2, 4, 7, 9 };

        for (int key : keys) {
            root = insert(root, key);
        }

        System.out.println("In-order traversal:");
        inOrderTraversal(root);
    }
}
