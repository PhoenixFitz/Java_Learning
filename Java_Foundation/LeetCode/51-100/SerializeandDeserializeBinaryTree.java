package stage.two.klaus;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer,
 * or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm
 * should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original
 * tree structure.
 */
public class SerializeandDeserializeBinaryTree {


    private static final String spliter = ",";
    private static final String NN = "X";


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sbu = new StringBuilder();
        buildString(root, sbu);
        return sbu.toString();

    }

    public void buildString(TreeNode node, StringBuilder sbu){
        if(node == null){
            sbu.append(NN).append(spliter);
        }else{
            sbu.append(node.val).append(spliter);
            buildString(node.left, sbu);
            buildString(node.right, sbu);
        }

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        //LinkedList 大小可变的链表双端队列，允许元素为 null
        //ArrayDeque 大下可变的数组双端队列，不允许 null
        Deque<String> deq = new LinkedList<>();
        deq.addAll(Arrays.asList(data.split(spliter)));
        return buildTree(deq);

    }

    public TreeNode buildTree(Deque<String> nodes){
        String val = nodes.poll();
        if(val.equals(NN))
            return null;
        else{
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }

}
