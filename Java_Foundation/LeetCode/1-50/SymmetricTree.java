package stage.one.klaus;

import java.util.*;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * But the following [1,2,2,null,3,null,3] is not:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 */

public class SymmetricTree {

    //判断二叉树是否是平衡树，比如有两个节点n1, n2，我们需要比较n1的左子节点的值和n2的右子节点的值是否相等，同时还要比较n1的右子节点
    // 的值和n2的左子结点的值是否相等，以此类推比较完所有的左右两个节点。

    //递归
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        return symmetric(root.left, root.right);

    }

    public boolean symmetric(TreeNode le, TreeNode rig ){
        if(le == null && rig == null)
            return true;
        if((le == null && rig != null) || (le != null && rig == null) || (le.val != rig.val))
            return false;
        return symmetric(le.left, rig.right) && symmetric(le.right, rig.left);
    }

    //迭代
    public boolean isSymmetric02(TreeNode root){
        //LinkedList类实现了Queue接口，因此我们可以把LinkedList当成Queue来用。add()和remove()方法在失败的时候会抛出异常(不推荐)
        //要使用offer()来加入元素，使用poll()来获取并移出元素。它们的优点是通过返回值可以判断成功与否,如果要使用前端而不移出该元素，使用
        //element()或者peek()方法。

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();
            if(t1 == null && t2 == null)
                continue;
            if(t1 == null || t2 == null)
                return false;
            if(t1.val != t2.val)
                return false;
            queue.offer(t1.right);
            queue.offer(t2.left);
            queue.offer(t1.left);
            queue.offer(t2.right);
        }
        return true;
    }
}
