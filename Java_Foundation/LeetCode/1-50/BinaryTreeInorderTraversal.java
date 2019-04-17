package stage.one.klaus;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * Example:
 *
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * Output: [1,3,2]
 */
public class BinaryTreeInorderTraversal {


    //递归
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        recursion(root, list);
        return list;
    }

    public void recursion(TreeNode root, List<Integer> list){
        if(root == null)
            return;
        if(root.left != null){
            recursion(root.left, list);
        }
        list.add(root.val);
        if(root.right != null){
            recursion(root.right, list);
        }
    }


    //非递归
    public List<Integer> inorderTraversal02(TreeNode root){
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while(p != null || !stack.isEmpty()){
            if (p != null){
                stack.push(p);
                p = p.left;
            }else {  //p == null && !stack.isEmpty()
                TreeNode temp = stack.pop();
                list.add(temp.val);
                p = temp.right;
            }
        }
        return list;
    }
}





class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }