package stage.two.klaus;


public class LinkedListCycle02 {
    /**
     * 这次要记录两个指针相遇的位置，当两个指针相遇了后，让其中一个指针从链表头开始，此时再相遇的位置就是链表中环的起始位置，
     * 因为快指针每次走2，慢指针每次走1，快指针走的距离是慢指针的两倍。而快指针又比慢指针多走了一圈。
     * 所以head到环的起点+环的起点到他们相遇的点的距离 与 环一圈的距离相等。
     */
    public ListNode detectCycle(ListNode head){
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                slow = head;
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return fast;
            }
        }

        return null;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}