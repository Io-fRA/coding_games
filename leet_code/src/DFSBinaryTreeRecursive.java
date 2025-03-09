import java.util.*;

public class DFSBinaryTreeRecursive {

    // Recursive Preorder DFS Traversal
    public static void dfsPreorder(TreeNode root) {
        if (root == null) {
            return;  // Base case: if the node is null, return
        }
        // Process the current node
        System.out.print(root.val + " ");
        // Recursively visit the left subtree
        dfsPreorder(root.left);
        // Recursively visit the right subtree
        dfsPreorder(root.right);
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

        // Perform DFS Preorder Traversal
        System.out.println("DFS Preorder Traversal:");
        dfsPreorder(root);
    }
}
