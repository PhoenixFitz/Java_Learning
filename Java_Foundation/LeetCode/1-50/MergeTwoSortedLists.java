package leetcode.klaus;

/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 * Example:
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */
public class MergeTwoSortedLists {

    public static void main(String[] args){

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if(l1 == null && l2 == null)
            return null;
        if(l1 == null && l2 != null)
            return l2;
        if(l1 != null && l2 == null)
            return l1;
        ListNode t1 = l1;
        ListNode t2 = l2;
        //whichever list is starting with least, make it t1;
        while(t1.val > t2.val){
            ListNode temp = t2;
            t2 = t1;
            t1 = temp;
        }
        l1 = t1; //this is what you return eventually
        while(t1.next != null && t2 != null){
            if(t1.val <= t2.val && t1.next.val <= t2.val ){
                t1 = t1.next;  // proceed if both are less.
            }else if(t1.val <= t2.val && t1.next.val > t2.val){
                // if t2.val comes in b/w, connect t2,
                // and make t1.next as t2.
                ListNode temp = t2;
                t2 = t1.next;
                t1.next =temp;
            }
        }
        //If the first list reaches end, just connect to second list.
        if(t1.next == null){
            t1.next = t2;
        }
        return l1;
    }


}


