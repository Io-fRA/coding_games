import java.util.*;

public class DFSBinaryTreeIterative {

    // Iterative Preorder DFS Traversal using Stack
    public static void dfsPreorderIterative(TreeNode root) {
        if (root == null) {
            return;  // If the root is null, return
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.val + " ");  // Process the current node

            // Push right child first so left child is processed first
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    public static void main(String[] args) {
        // Create a simple binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        // Perform DFS Preorder Traversal (Iterative)
        System.out.println("DFS Preorder Traversal (Iterative):");
        dfsPreorderIterative(root);
    }
}
