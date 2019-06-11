package stage.two.klaus;

import java.util.*;

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 *
 * Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]
 */
public class LowestCommonAncestorofaBinaryTree {

    /**
     * 在二叉树中来搜索p和q，然后从路径中找到最后一个相同的节点即为父节点，我们可以用递归来实现，在递归函数中，我们首先看当前结点是否为空，
     * 若为空则直接返回空，若为p或q中的任意一个，也直接返回当前结点。否则的话就对其左右子结点分别调用递归函数，由于这道题限制了p和q一定都在二叉树中存在，
     * 那么如果当前结点不等于p或q，p和q要么分别位于左右子树中，要么同时位于左子树，或者同时位于右子树，那么我们分别来讨论：
     *
     * 1.若p和q要么分别位于左右子树中，那么对左右子结点调用递归函数，会分别返回p和q结点的位置，而当前结点正好就是p和q的最小共同父结点，
     * 直接返回当前结点即可，这就是题目中的例子1的情况。
     *
     * 2.若p和q同时位于左子树，这里有两种情况，一种情况是left会返回p和q中较高的那个位置，而right会返回空，所以我们最终返回非空的left即可，
     * 这就是题目中的例子2的情况。还有一种情况是会返回p和q的最小父结点，就是说当前结点的左子树中的某个结点才是p和q的最小父结点，会被返回。
     *
     * 3.若p和q同时位于右子树，同样这里有两种情况，一种情况是right会返回p和q中较高的那个位置，而left会返回空，所以我们最终返回非空的right即可，
     * 还有一种情况是会返回p和q的最小父结点，就是说当前结点的右子树中的某个结点才是p和q的最小父结点，会被返回
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null)
            return root;
        return left != null ? left : right;
    }
    //Iterative using parent pointers

    /**
     *  If we have parent pointers for each node we can traverse back from p and q to get their ancestors.
     *  The first common node we get during this traversal would be the LCA node. We can save the parent pointers in a dictionary as
     *  we traverse the tree.
     *
     *
     * 1.Start from the root node and traverse the tree.
     * 2.Until we find p and q both, keep storing the parent pointers in a dictionary.
     * 3.Once we have found both p and q, we get all the ancestors for p using the parent dictionary and add to a set called ancestors.
     * 4.Similarly, we traverse through ancestors for node q. If the ancestor is present in the ancestors set for p,
     * this means this is the first ancestor common between p and q (while traversing upwards) and hence this is the LCA node.
     */

    public TreeNode lowestCommonAncestor02(TreeNode root, TreeNode p, TreeNode q){
        // Stack for tree traversal
        Stack<TreeNode> stack = new Stack<>();
        // HashMap for parent pointers
        Map<TreeNode,TreeNode> parent = new HashMap<>();
        parent.put(root, null);
        stack.push(root);

        // Iterate until we find both the nodes p and q
        while(!parent.containsKey(p) || !parent.containsKey(q)){
            TreeNode node = stack.pop();
            // While traversing the tree, keep saving the parent pointers
            if(node.left != null){
                parent.put(node.left, node);
                stack.push(node.left);
            }

            if(node.right != null){
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }

        // Ancestors set() for node p.
        Set<TreeNode> ancestors = new HashSet<>();
        while(p != null){
            ancestors.add(p);
            p = parent.get(p);
        }

        // Process all ancestors for node p using parent pointers.
        while(!ancestors.contains(q)){
            q = parent.get(q);
        }

        return q;
    }

}
