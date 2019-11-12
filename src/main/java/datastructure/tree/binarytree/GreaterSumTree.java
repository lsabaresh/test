package datastructure.tree.binarytree;

import datastructure.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class GreaterSumTree {

    public static void main(String[] args) {
        GreaterSumTree t = new GreaterSumTree();

        TreeNode root = Tree.buildTree(new Integer[]{4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8});

        t.bstToGst(root);
    }

    // Iterative
    public TreeNode bstToGstIterative(TreeNode root) {
        int sum = 0;
        TreeNode cur = root;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.right;
            }
            cur = stack.pop();
            cur.val += sum;
            sum = cur.val;
            cur = cur.left;
        }
        return root;
    }

    // Recursive method
    public TreeNode bstToGst(TreeNode root) {
        List<TreeNode> treeInAscOrder = inOrderTraversalRecursive(root);
        for (int i = treeInAscOrder.size()-2; i >=0; i--) {
            treeInAscOrder.get(i).val += treeInAscOrder.get(i+1).val;
        }
        return root;
    }


    public static List<TreeNode> inOrderTraversalRecursive(TreeNode root) {
        List<TreeNode> pre = new ArrayList<>();
        inOrderTraversalRecursiveHelper(root, pre);
        return pre;
    }

    public static void inOrderTraversalRecursiveHelper(TreeNode root, List<TreeNode> pre) {
        if (root != null) {
            inOrderTraversalRecursiveHelper(root.left, pre);
            pre.add(root);
            inOrderTraversalRecursiveHelper(root.right, pre);
        }
    }
}
