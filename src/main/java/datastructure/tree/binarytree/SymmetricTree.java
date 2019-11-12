package datastructure.tree.binarytree;

import datastructure.tree.TreeNode;

import java.util.*;

public class SymmetricTree {

    public static void main(String []args) {



        System.out.println(isSymmetric(null) == true);

        System.out.println(isSymmetric(Tree.buildTree(new Integer[]{})) == true);

        System.out.println(isSymmetric(Tree.buildTree(new Integer[]{1})) == true);

        System.out.println(isSymmetric(Tree.buildTree(new Integer[]{1, 2, 2})) == true);

        System.out.println(isSymmetric(Tree.buildTree(new Integer[]{1, 2, 2, 3, 4, 4, 3})) == true);

        System.out.println(isSymmetric(Tree.buildTree(new Integer[]{1, 2, 2, 3, 4, 3, 4})) == false);

        System.out.println(isSymmetric(Tree.buildTree(new Integer[]{1, 2, 2, null, 3, 3, null})) == true);

        System.out.println(isSymmetric(Tree.buildTree(new Integer[]{2,3,3,4,5,5,4,null,null,8,9,9,8, null, null})) == true);

        int input[] = new int[]{1, 2, 3};

        Arrays.sort(new int[]{1, 2, 3});

    }

    public static boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        return isSymmetricHelper(root.left, root.right);
    }
    public static boolean isSymmetricHelper(TreeNode left, TreeNode right) {
        if(left == null || right == null)
            return left == right;
        return left.val == right.val && isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);
    }


    public static boolean isSymmetric2(TreeNode root) {

        if (root == null  || (root.right == null && root.left == null) ) {
            return true;
        }

        Deque<Optional<TreeNode>> queue = new ArrayDeque();
        queue.add(Optional.ofNullable(root));

        while (!queue.isEmpty()) {
            ArrayList<TreeNode> levelList = new ArrayList<>();

            boolean allLeafsNull = true;
            while (!queue.isEmpty()) {
                Optional<TreeNode> optNode = queue.pop();
                if (optNode.isPresent()) {
                    allLeafsNull = false;

                    TreeNode node = optNode.get();
                    levelList.add(node.left);
                    levelList.add(node.right);
                } else {
                    levelList.add(null);
                    levelList.add(null);
                }
            }

            int currentSize = levelList.size();

            if (currentSize == 0 || allLeafsNull) {
                return true;
            } else if (currentSize % 2 != 0) {
                return false;
            }

            int centerIndex = (currentSize / 2);

            for (int i = 0, j = currentSize -1; i < centerIndex && j >= centerIndex; i++, j--) {
                TreeNode tree1 = levelList.get(i);
                TreeNode tree2 = levelList.get(j);

                if (tree1 == null && tree2 == null) {
                    continue;
                } else  if ( (tree1 == null && tree2 != null) || (tree1 != null && tree2 == null) || (tree1.val != tree2.val)) {
                    return false;
                }
            }

            for (int i = 0; i < currentSize; i++) {
                queue.add(Optional.ofNullable(levelList.get(i)));
            }
        }

        return true;
    }

    public boolean isSymmetric3(TreeNode root) {
        if(root==null)  return true;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode left, right;
        if(root.left!=null){
            if(root.right==null) return false;
            stack.push(root.left);
            stack.push(root.right);
        }
        else if(root.right!=null){
            return false;
        }

        while(!stack.empty()){
            if(stack.size()%2!=0)   return false;
            right = stack.pop();
            left = stack.pop();
            if(right.val!=left.val) return false;

            if(left.left!=null){
                if(right.right==null)   return false;
                stack.push(left.left);
                stack.push(right.right);
            }
            else if(right.right!=null){
                return false;
            }

            if(left.right!=null){
                if(right.left==null)   return false;
                stack.push(left.right);
                stack.push(right.left);
            }
            else if(right.left!=null){
                return false;
            }
        }

        return true;
    }

    public boolean isSymmetric4(TreeNode root) {
        if(root == null) return true;
        Deque<TreeNode> st = new LinkedList<>();
        st.addFirst(root.left);
        st.addFirst(root.right);
        while(!st.isEmpty()) {
            TreeNode t1,t2;
            t1= st.removeFirst();
            t2 = st.removeFirst();
            if(t1 == null && t2 == null && st.isEmpty()) break;
            if(t1 == null && t2 == null && !st.isEmpty()) continue;
            if(t1 == null && t2 != null) return false;
            if(t1 != null && t2 == null) return false;
            if(t1.val != t2.val) return false;
            st.addFirst(t1.left);
            st.addFirst(t2.right);
            st.addFirst(t1.right);
            st.addFirst(t2.left);
        }
        return true;
    }
}
