package stage.two.klaus;

/**
 * Example:
 *
 * Input:
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * Output:
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * Definition for a binary tree node.
 */
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return root;

        TreeNode l = invertTree(root.left);

        TreeNode r = invertTree(root.right);
        root.left = r;
        root.right = l;
        return root;
    }
}

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}