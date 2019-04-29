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
}
