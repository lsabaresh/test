package datastructure.tree.binarytree;

import datastructure.tree.TreeNode;

import java.util.*;

public class PreOrderTraversalTest {

    public static void main(String[] args) {
        Integer[] input = {1, null, 2, null, null, 3};

        // Iterative method
        System.out.println(preOrderTraversal(Tree.buildTree(input)));

        // Recursive method
        System.out.println(preOrderTraversalRecursive(Tree.buildTree(input)));
    }

    // Iterative method
    public static List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> pre = new ArrayList<>();

        if (root == null) {
            return pre;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while ( !stack.isEmpty() ) {
            root = stack.pop();
            if (root != null) {
                pre.add(root.val);
                if (root.right != null) {
                    stack.push(root.right);
                }
                if (root.left != null) {
                    stack.push(root.left);
                }
            }
        }
        return pre;
    }

    // Recursive method
    public static List<Integer> preOrderTraversalRecursive(TreeNode root) {
        List<Integer> pre = new ArrayList<>();
        preOrderTraversalRecursiveHelper(root, pre);
        return pre;
    }

    public static void preOrderTraversalRecursiveHelper(TreeNode root, List<Integer> pre) {
        if (root != null) {
            pre.add(root.val);
            preOrderTraversalRecursiveHelper(root.left, pre);
            preOrderTraversalRecursiveHelper(root.right, pre);
        }
    }

}
