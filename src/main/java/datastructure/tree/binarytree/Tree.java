package datastructure.tree.binarytree;

// Java program to construct binary tree from
// given array in level order fashion

import datastructure.tree.TreeNode;

public class Tree {
//    TreeNode root;

//    // Tree TreeNode
//    static class TreeNode {
//        int data;
//        TreeNode left, right;
//        TreeNode(int data)
//        {
//            this.data = data;
//            this.left = null;
//            this.right = null;
//        }
//    }

    // Function to insert TreeNodes in level order
    public static TreeNode insertLevelOrder(Integer[] arr, TreeNode root,
                                 int i)
    {
        // Base case for recursion
        if (i < arr.length) {
            if (arr[i] == null) {
                return null;
            }

            TreeNode temp = new TreeNode(arr[i]);
            root = temp;

            // insert left child
            root.left = insertLevelOrder(arr, root.left,
                    2 * i + 1);

            // insert right child
            root.right = insertLevelOrder(arr, root.right,
                    2 * i + 2);
        }
        return root;
    }

    // Function to print tree TreeNodes in InOrder fashion
    public void inOrder(TreeNode root)
    {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.val + " ");
            inOrder(root.right);
        }
    }

    // Driver program to test above function
    public static void main(String args[])
    {
        Tree t2 = new Tree();
        Integer arr[] = { 1, 2, 3, 4, 5, 6, 6, 6, 6 };
        TreeNode root = t2.insertLevelOrder(arr, null, 0);
        t2.inOrder(root);
    }

    public static TreeNode buildTree(Integer arr[])
    {
//        Tree tree = new Tree();
//        return
//        int arr[] = { 1, 2, 3, 4, 5, 6, 6, 6, 6 };
//        t2.root = t2.insertLevelOrder(arr, t2.root, 0);
//        t2.inOrder(t2.root);
        return insertLevelOrder(arr, null, 0);
    }
}

