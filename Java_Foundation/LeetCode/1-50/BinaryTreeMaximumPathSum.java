package stage.one.klaus;

/**
 * Given a non-empty binary tree, find the maximum path sum.
 *
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections.
 * The path must contain at least one node and does not need to go through the root.
 *
 */
public class BinaryTreeMaximumPathSum {


    /**
     * 在递归函数中，如果当前结点不存在，那么直接返回0。否则就分别对其左右子节点调用递归函数，由于路径和有可能为负数，而我们当然不希望加上负的路径和，
     * 所以我们和0相比，取较大的那个，就是要么不加，加就要加正数。然后我们来更新全局最大值结果res，
     * 就是以左子结点为终点的最大path之和加上以右子结点为终点的最大path之和，还要加上当前结点值，这样就组成了一个条完整的路径。
     * 而我们返回值是取left和right中的较大值加上当前结点值，因为我们返回值的定义是以当前结点为终点的path之和，所以只能取left和right中较大的那个值，
     * 而不是两个都要，
     * @param root
     * @return
     */
    int result = Integer.MIN_VALUE; //全局变量
    int maxPathSum(TreeNode root){

        backtrack(root);
        return result;
    }

    public int backtrack(TreeNode root){
        if(root == null)
            return 0;
        int left = Math.max(0,backtrack(root.left));  //取大于0的值
        int right = Math.max(0,backtrack(root.right));
        result = Math.max(result, left + right + root.val);
        return root.val + Math.max(left, right);
    }

}
