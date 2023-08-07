import java.util.ArrayList;

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class Solution {
    ArrayList<Integer> boundary(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;

        // Print the root node
        result.add(root.data);

        // Print the left boundary in top-down manner.
        printBoundaryLeft(root.left, result);

        // Print all leaf nodes
        printLeaves(root.left, result);
        printLeaves(root.right, result);

        // Print the right boundary in bottom-up manner
        printBoundaryRight(root.right, result);

        return result;
    }

    // A simple function to print leaf nodes of a binary tree
    void printLeaves(Node node, ArrayList<Integer> result) {
        if (node == null) return;

        printLeaves(node.left, result);

        // Print it if it is a leaf node
        if (node.left == null && node.right == null)
            result.add(node.data);

        printLeaves(node.right, result);
    }

    // A function to print all left boundary nodes, except a leaf node.
    // Print the nodes in TOP DOWN manner
    void printBoundaryLeft(Node node, ArrayList<Integer> result) {
        if (node == null || (node.left == null && node.right == null))
            return;

        result.add(node.data);

        if (node.left != null)
            printBoundaryLeft(node.left, result);
        else if (node.right != null)
            printBoundaryLeft(node.right, result);
    }

    // A function to print all right boundary nodes, except a leaf node
    // Print the nodes in BOTTOM UP manner
    void printBoundaryRight(Node node, ArrayList<Integer> result) {
        if (node == null || (node.left == null && node.right == null))
            return;

        if (node.right != null)
            printBoundaryRight(node.right, result);
        else if (node.left != null)
            printBoundaryRight(node.left, result);

        result.add(node.data);
    }
}


