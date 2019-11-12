package datastructure.tree.binarytree;

import datastructure.tree.TreeNode;

public class MaxDepth {

    public static void main(String []arg) {

        Integer[] input = {1, null, 2, null, null, 3};

        System.out.println("Height : "+maxDepth(Tree.buildTree(input)));

    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
