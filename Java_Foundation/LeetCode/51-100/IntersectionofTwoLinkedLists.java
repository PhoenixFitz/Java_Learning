package stage.two.klaus;

/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 */
public class IntersectionofTwoLinkedLists {

    /**
     * 方法1：如果两个链长度相同的话，那么对应的一个个比下去就能找到，所以只需要把长链表变短即可。
     * 具体算法为：分别遍历两个链表，得到分别对应的长度。然后求长度的差值，把较长的那个链表向后移动这个差值的个数，然后一一比较即可。
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        if(headA == null || headB == null)
            return null;
        int lenA = getLength(headA);
        int lenB = getLength(headB);
        if(lenA < lenB){
            for(int i = 0; i < lenB - lenA; i++){
                headB = headB.next;
            }
        }else{
            for(int i = 0; i < lenA - lenB; i++){
                headA = headA.next;
            }
        }
        while(headA != null && headB != null && headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return (headA != null && headB != null) ? headA : null;

    }

    int getLength(ListNode head){
        int count = 0;
        while(head != null){
            count++;
            head = head.next;
        }
        return count;
    }


    /**
     * 方法2：让两条链表分别从各自的开头开始往后遍历，当其中一条遍历到末尾时，跳到另一个条链表的开头继续遍历。两个指针最终会相等，
     * 而且只有两种情况，一种情况是在交点处相遇，另一种情况是在各自的末尾的空节点处相等。为什么一定会相等呢，因为两个指针走过的路程相同，
     * 是两个链表的长度之和，所以一定会相等。
     * To see why the above trick would work, consider the following two lists: A = {1,3,5,7,9,11} and B = {2,4,9,11},
     * which are intersected at node '9'. Since B.length (=4) < A.length (=6), pB would reach the end of the merged list first,
     * because pB traverses exactly 2 nodes less than pApA does. By redirecting pB to head A, and pA to head B,
     * we now ask pB to travel exactly 2 more nodes than pApA would. So in the second iteration, they are guaranteed to
     * reach the intersection node at the same time.
     */

    public ListNode getIntersectionNode02(ListNode headA, ListNode headB){
        if(headA == null || headB == null)
            return null;
        ListNode pA = headA , pB = headB;
        while(pA != pB){
            pA = (pA != null) ? pA.next : headB;
            pB = (pB != null) ? pB.next : headA;
        }
        return pA;
    }
}
