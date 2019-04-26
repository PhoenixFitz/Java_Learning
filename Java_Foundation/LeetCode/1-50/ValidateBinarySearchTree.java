package stage.one.klaus;


import java.util.Stack;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 */
public class ValidateBinarySearchTree {

    //利用二叉搜索树的性质
    public boolean isValidBST(TreeNode02 root) {
        if (root == null) return true;
        return  valid(root,Long.MIN_VALUE, Long.MAX_VALUE);

    }

    public boolean valid(TreeNode02 node,long low, long high){  //用long代替int就是为了包括int的边界条件
        if(node == null)
            return true;
        if(node.val >= high || node.val <= low)
            return false;
        return valid(node.left, low, node.val) && valid(node.right,node.val, high);
    }

    //非递归中序遍历 （因为改题目设定为左<根<右，可以用中序做。若为左<=根<右，难度增大，中序遍历不好用了）

    public boolean isValidBST02(TreeNode02 root){
        Stack<TreeNode02> stack = new Stack<>();
        TreeNode02 p = root, pre = null;
        while(p != null || !stack.isEmpty()){
            while(p != null){
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();  //取出栈顶元素
            if(pre != null && pre.val >= p.val)// 栈顶元素跟之前取出的元素进行值比较
                return false;
            pre = p;
            p = p.right;

        }

        return true;
    }

}



class TreeNode02 {
     int val;
     TreeNode02 left;
     TreeNode02 right;
     TreeNode02(int x) { val = x; }
 }