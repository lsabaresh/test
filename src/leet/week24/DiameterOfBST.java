package leet.week24;

import leet.TreeNode;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by sabaresh on 3/18/17.
 */
public class DiameterOfBST {

    public static void main(String[] args) {

        DiameterOfBST d = new DiameterOfBST();

        TreeNode root = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        root.left = two;
        root.right = three;

        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        two.left = four;
        two.right = five;

        System.out.println(d.diameterOfBinaryTree(root));
    }

    public int diameterOfBinaryTree(TreeNode root) {

        if(root == null ) return 0;

        System.out.println("root " +root.val);

        int leftLevel = 0;
        if(root.left != null ) {
            leftLevel = load(root.left, leftLevel);
        }

        System.out.println("root.left " +(root.left != null ? root.left.val : "")+", leftLevel : "+leftLevel);

        int rightLevel = 0;
        if(root.right != null ) {
            rightLevel = load(root.right, rightLevel);
        }

        System.out.println("root.right " +(root.right != null ? root.right.val : "")+", rightLevel : "+rightLevel);

        return leftLevel + rightLevel;
    }

    public Integer load(TreeNode node, int level) {

        if( node == null ) return level;


        level++;
        System.out.println("node val "+node.val+", level : "+level+", node.left : "+(node.left != null ? node.left.val : "") +", node.right : "+(node.right != null ? node.right.val : ""));

        int leftLevel = level, rightLevel = level;
        if(node.left != null ) {
            leftLevel = load(node.left, leftLevel);
        }

        if(node.right != null ) {
            rightLevel = load(node.right, rightLevel);
        }

        if(level < leftLevel) {
            level = leftLevel;
        }

        if(level < rightLevel) {
            level = rightLevel;
        }

        return level;
    }
}

