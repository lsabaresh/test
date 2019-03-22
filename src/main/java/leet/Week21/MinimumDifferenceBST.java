package leet.Week21;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by sabaresh on 2/25/17.
 */
public class MinimumDifferenceBST {

    public static void main(String[] args) {
        MinimumDifferenceBST m = new MinimumDifferenceBST();

        TreeNode root = new TreeNode(1);
        TreeNode three = new TreeNode(3);
        root.left = null;
        root.right = three;
        three.left = new TreeNode(2);

        System.out.println(m.getMinimumDifference(root));

    }

    public int getMinimumDifference(TreeNode root) {

        TreeNode currentNode = root;

        ArrayList<Integer> data = new ArrayList<>();

        load(root, data);

//        System.out.println("data unsorted : "+data);

        if(data != null) Collections.sort(data);

//        System.out.println("data : "+data);

        int mDiff = 0;

        for (int i=0 ; i < data.size() -1 ; i++) {

            if( (data.get(i+1) - data.get(i)) <= mDiff || mDiff ==0 ) {
                mDiff = (data.get(i+1) - data.get(i));
            }
        }

        return mDiff;
    }

    public void load(TreeNode node, ArrayList<Integer> data) {

        if( node == null ) return;

        data.add(node.val);

        if(node.left != null ) {
            load(node.left, data);
        }

        if(node.right != null ) {
            load(node.right, data);
        }
    }

}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}
