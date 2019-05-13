package stage.two.klaus;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity,
 * it should invalidate the least recently used item before inserting a new item.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * The problem can be solved with a hashtable that keeps track of the keys and its values in the double linked list.
 * One interesting property about double linked list is that the node can remove itself without other reference.
 * In addition, it takes constant time to add and remove nodes from the head or tail.
 *
 * One particularity about the double linked list that I implemented is that I create a pseudo head and tail to mark the boundary,
 * so that we don't need to check the NULL node during the update. This makes the code more concise and clean,
 * and also it is good for the performance as well.
 */
public class LRUCache {

    Map<Integer,DoubleLinkedNode> map = new HashMap<>();
    int capacity;
    int count;
    DoubleLinkedNode head,tail;


    class DoubleLinkedNode{
        DoubleLinkedNode pre;
        DoubleLinkedNode next;
        int val;
        int key;
    }
//Always add the new node right after head;
    private void addNode(DoubleLinkedNode node){
        node.next = head.next;
        node.pre = head;

        head.next.pre = node;
        head.next = node;
    }
//Remove an existing node from the linked list.
    private void removeNode(DoubleLinkedNode node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
//Move certain node in between to the head.
    private void moveToHead(DoubleLinkedNode node){
        this.removeNode(node);
        this.addNode(node);
    }
//pop the current tail.
    private DoubleLinkedNode popTail(){
        DoubleLinkedNode res = tail.pre;
        this.removeNode(res);
        return res;
    }

    public LRUCache(int capacity){
        this.capacity = capacity;
        count = 0;

        head = new DoubleLinkedNode();
        head.pre = null;

        tail = new DoubleLinkedNode();
        tail.next = null;

        head.next = tail;
        tail.pre = head;
    }

    public int get(int key){
        DoubleLinkedNode temp = map.get(key);
        if(temp == null)
            return -1;// should raise exception here.

        this.moveToHead(temp);// move the accessed node to the head;
        return temp.val;
    }

    public void put(int key, int value){
        DoubleLinkedNode temp = map.get(key);
        if(temp == null){
            DoubleLinkedNode newNode = new DoubleLinkedNode();
            newNode.val = value;
            newNode.key = key;
            this.addNode(newNode);
            map.put(key, newNode);
            count++;
            if(count > capacity){
                //pop the tai;
                DoubleLinkedNode tail = this.popTail();
                map.remove(tail.key);
                --count;
            }
        }else{
            // update the value.
            temp.val = value;
            this.moveToHead(temp);
        }
    }

}
