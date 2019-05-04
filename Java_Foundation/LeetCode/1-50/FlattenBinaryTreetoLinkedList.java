package stage.one.klaus;

/**
 * Given a binary tree, flatten it to a linked list in-place.
 *
 * For example, given the following tree:
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * The flattened tree should look like:
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 *
 *           http://www.cnblogs.com/grandyang/p/4293853.html
 */
public class FlattenBinaryTreetoLinkedList {

    //recursion
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        if (root.left != null)
            flatten(root.left);
        if (root.right != null)
            flatten(root.right);
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = null;
        while(root.right != null)
            root = root.right;
        root.right = temp;
    }


    //Non-recursion
    public void flatten02(TreeNode root){
        if (root == null)
            return;
        TreeNode cur = root;
        while(cur != null){
            if(cur.left != null) {
                TreeNode temp = cur.left;
                while (temp.right != null)
                    temp = temp.right;
                temp.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }
            cur = cur.right;
        }
    }


}
