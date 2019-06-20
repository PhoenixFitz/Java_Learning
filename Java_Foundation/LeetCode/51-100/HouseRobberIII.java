package stage.two.klaus;

import java.util.HashMap;
import java.util.Map;

/**
 *The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.
 *
 * Determine the maximum amount of money the thief can rob tonight without alerting the police.
 *
 * Example 1:
 *
 * Input: [3,2,3,null,3,null,1]
 *
 *      3
 *     / \
 *    2   3
 *     \   \
 *      3   1
 *
 * Output: 7
 * Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 * Example 2:
 *
 * Input: [3,4,5,1,3,null,1]
 *
 *      3
 *     / \
 *    4   5
 *   / \   \
 *  1   3   1
 *
 * Output: 9
 * Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
 *
 * Definition for a binary tree node.
 *   public class TreeNode {
 *       int val;
 *       TreeNode left;
 *       TreeNode right;
 *       TreeNode(int x) { val = x; }
 *   }
 */
public class HouseRobberIII {

    /**
     * 我们可以利用回溯法来做，因为当前的计算需要依赖之前的结果，那么我们对于某一个节点，如果其左子节点存在，我们通过递归调用函数，
     * 算出不包含左子节点返回的值，同理，如果右子节点存在，算出不包含右子节点返回的值，那么此节点的最大值可能有两种情况，
     * 一种是该节点值加上不包含左子节点和右子节点的返回值之和，另一种是左右子节点返回值之和不包含当期节点值，取两者的较大值返回即可，但是这种方法无法通过OJ，
     * 超时了，所以我们必须优化这种方法，这种方法重复计算了很多地方，比如要完成一个节点的计算，就得一直找左右子节点计算，我们可以把已经算过的节点用哈希表保存起来，
     * 以后递归调用的时候，现在哈希表里找，如果存在直接返回，如果不存在，等计算出来后，保存到哈希表中再返回，这样方便以后再调用，
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        Map<TreeNode,Integer> map = new HashMap<>();
        return dfs(root, map);

    }

    public int dfs(TreeNode root, Map<TreeNode,Integer> map){
        if(root == null)
            return 0;
        if(map.containsKey(root))
            return map.get(root);
        int val = 0;
        if(root.left != null){
            val += dfs(root.left.left, map) + dfs(root.left.right, map);
        }
        if(root.right != null){
            val += dfs(root.right.left,map) + dfs(root.right.right,map);
        }

        val = Math.max(val + root.val, dfs(root.left, map) + dfs(root.right, map));
        map.put(root, val);
        return val;
    }

    //方法二
    /**
     * 这种方法的递归函数返回一个大小为2的一维数组res，其中res[0]表示不包含当前节点值的最大值，res[1]表示包含当前值的最大值，
     * 那么我们在遍历某个节点时，首先对其左右子节点调用递归函数，分别得到包含与不包含左子节点值的最大值，和包含于不包含右子节点值的最大值，
     * 那么当前节点的res[0]就是左子节点两种情况的较大值加上右子节点两种情况的较大值，res[1]就是不包含左子节点值的最大值加上不包含右子节点值的最大值，
     * 和当前节点值之和，返回即可，
     */

    public int rob02(TreeNode root){
        int[] res = dfs02(root);
        return Math.max(res[0], res[1]);
    }

    public int[] dfs02(TreeNode root){
        if(root == null)
            return new int[]{0,0};
        int[] left = dfs02(root.left);
        int[] right = dfs02(root.right);
        int[] res = new int[2];//res[0]表示不包含当前节点值的最大值，res[1]表示包含当前值的最大值，
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0],right[1]);
        res[1] = left[0] + right[0] + root.val;
        return res;

    }
}
