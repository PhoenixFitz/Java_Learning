package leetcode.klaus;

/**
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * Example:
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 */
public class RemoveNthNodeFromEndofList {

    public static void main(String[] args){

    }

    //two pass algorithm
    public static ListNode removeNthFromEnd01(ListNode head, int n){
        ListNode dummy = new ListNode(0);    // 有可能删除第一个节点，因此在头节点前建立一个 dummy node
        dummy.next = head;
        int length = 0;
        ListNode temp = head;
        while(temp != null){
            length++;
            temp = temp.next;
        }
        int move = length - n;
        temp = dummy;
        while(move > 0){
            temp = temp.next;
            move--;
        }
        temp.next = temp.next.next;
        return dummy.next;
    }

    //one pass algorithm

    /**
     * The first pointer advances the list by n+1n+1 steps from the beginning, while the second pointer starts from the beginning of the list.
     * Now, both pointers are exactly separated by nn nodes apart.
     * We maintain this constant gap by advancing both pointers together until the first pointer arrives past the last node.
     * The second pointer will be pointing at the nnth node counting from the last.
     * We relink the next pointer of the node referenced by the second pointer to point to the node's next next node.
     */
    public static ListNode removeNthFromEnd02(ListNode head, int n){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        for(int i = 1; i <= n + 1; i++){
            first = first.next;
        }
        while(first != null){
            second = second.next;
            first = first.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

