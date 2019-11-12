package datastructure.tree.binarytree;

import datastructure.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestor {

    public static void main(String[] args) {
        System.out.println(lowestCommonAncestor(Tree.buildTree(new Integer[]{3,5,1,6,2,0,8,null,null,7,4}), new TreeNode(5), new TreeNode(1)));
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return left == null ? right : right == null ? left : root;
    }


    // My original solution
    public static TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pParents = new ArrayList<>();
        List<TreeNode> qParents = new ArrayList<>();
        findElement(root, p, pParents);
        findElement(root, q, qParents);

        for (int i=0; i < pParents.size(); i++) {
            for (int j=0; j < qParents.size(); j++) {
                if (pParents.get(i).val == qParents.get(j).val) {
                    return pParents.get(i);
                }
            }
        }
        return null;
    }

    private static boolean findElement(TreeNode root, TreeNode t, List<TreeNode> parents) {
        if (root == null) {
            return false;
        }

        if (root.val == t.val || findElement(root.left, t, parents) || findElement(root.right, t, parents)) {
            parents.add(root);
            return true;
        }
        return false;
    }
}
