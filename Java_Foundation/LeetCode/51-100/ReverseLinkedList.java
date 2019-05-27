package stage.two.klaus;

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head){
        ListNode p = null;
        while(head != null){
            ListNode t = head.next;
            head.next = p;
            p = head;
            head = t;
        }
        return p;
    }
}
