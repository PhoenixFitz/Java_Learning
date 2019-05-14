package leetcode.klaus;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 * Example 1:
 *
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 * Example 2:
 *
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 */
public class SortList {

    /**
     * 常见排序方法有很多，插入排序，选择排序，堆排序，快速排序，冒泡排序，归并排序，桶排序等等。。它们的时间复杂度不尽相同，
     * 而这里题目限定了时间必须为O(nlgn)，符合要求只有快速排序，归并排序，堆排序，而根据单链表的特点，最适于用归并排序。
     */

    public ListNode sortList(ListNode head){
        if(head == null || head.next == null)
            return head;

        //1. cut the list to two halves
        ListNode pre = head, slow = head, fast = head;
        while(fast != null && fast.next !=null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        //2. sort each half
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        //3.merge l1 and l2
        return merge(l1,l2);

    }

    public ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(-1), p = dummy;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                p.next = l1;
                l1 = l1.next;
            }else{
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if(l1 != null)
            p.next = l1;
        if(l2 != null)
            p.next = l2;
        return dummy.next;
    }
}
