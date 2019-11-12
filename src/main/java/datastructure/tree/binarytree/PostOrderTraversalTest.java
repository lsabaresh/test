package datastructure.tree.binarytree;

import datastructure.tree.TreeNode;

import java.util.*;

public class PostOrderTraversalTest {

    public static void main(String[] args) {
        Integer[] input = {1, null, 2, null, null, 3};



        // Iterative method
        System.out.println(postOrderTraversal(Tree.buildTree(input)));

        // Recursive method
        System.out.println(postOrderTraversalRecursive(Tree.buildTree(input)));
    }

    // Iterative method
    public static List<Integer> postOrderTraversal(TreeNode root) {
        LinkedList<Integer> pre = new LinkedList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        if (root == null) return pre;

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            pre.addFirst(cur.val);
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }
        return pre;
    }

    // Recursive method
    public static List<Integer> postOrderTraversalRecursive(TreeNode root) {
        List<Integer> pre = new ArrayList<>();
        postOrderTraversalRecursiveHelper(root, pre);
        return pre;
    }

    public static void postOrderTraversalRecursiveHelper(TreeNode root, List<Integer> pre) {
        if (root != null) {
            postOrderTraversalRecursiveHelper(root.left, pre);
            postOrderTraversalRecursiveHelper(root.right, pre);
            pre.add(root.val);
        }
    }

}
