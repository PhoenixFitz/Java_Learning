package stage.one.klaus;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

    //方法一
    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            for(int i = queue.size(); i > 0; i--){    //每次出队时，将上一层的所有节点全部出队，并将该层的节点全部入队
                TreeNode t = queue.poll();
                temp.add(t.val);
                if(t.left != null)
                    queue.offer(t.left);
                if(t.right != null)
                    queue.offer(t.right);
            }
            res.add(temp);
        }

        return res;
    }

    //方法二 递归
    public List<List<Integer>> levelOrder02(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();

        levelorder(root, 0, res);
        return res;
    }

    void levelorder(TreeNode treeNode, int level, List<List<Integer>> res){ //变量level来标记当前的深度
        if(treeNode == null)
            return;
        if(res.size() == level)  // level从0开始计数， 此时res.size()的大小 比 level少1，需要建立新的List加入到res中
            res.add(new ArrayList<>());
        res.get(level).add(treeNode.val);
        levelorder(treeNode.left, level + 1, res);
        levelorder(treeNode.right, level + 1,res);

    }

}
