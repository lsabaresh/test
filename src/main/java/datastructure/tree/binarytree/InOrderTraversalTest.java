package datastructure.tree.binarytree;

import datastructure.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class InOrderTraversalTest {

    public static void main(String[] args) {
        Integer[] input = {1, null, 2, null, null, 3};

        // Iterative method
        System.out.println(inOrderTraversal(Tree.buildTree(input)));

        // Recursive method
        System.out.println(inOrderTraversalRecursive(Tree.buildTree(input)));
    }

    // Iterative method
    public static List<Integer> inOrderTraversal(TreeNode root) {
        List<Integer> pre = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();

        while (root!= null || !stack.isEmpty()) {
            while (root!= null ) { // Travel to each node's left child, till reach the left leaf
                stack.push(root);
                root = root.left;
            }
            root = stack.pop(); // Backtrack to higher level node A
            pre.add(root.val); // Add the node to the result list
            root = root.right; // Switch to A'right branch
        }
        return pre;
    }

    // Recursive method
    public static List<Integer> inOrderTraversalRecursive(TreeNode root) {
        List<Integer> pre = new ArrayList<>();
        inOrderTraversalRecursiveHelper(root, pre);
        return pre;
    }

    public static void inOrderTraversalRecursiveHelper(TreeNode root, List<Integer> pre) {
        if (root != null) {
            inOrderTraversalRecursiveHelper(root.left, pre);
            pre.add(root.val);
            inOrderTraversalRecursiveHelper(root.right, pre);
        }
    }

}
