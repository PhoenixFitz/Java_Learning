package stage.one.klaus;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {

    public static void main(String[] args){
        List l1 = new ArrayList();
        l1.add(9);
        l1.add(9);

        List l2 = new ArrayList();
        l2.add(1);

        System.out.println(addTwoNumbers(l1,l2));
    }


    public static List addTwoNumbers(List l1, List l2){
        List head = new ArrayList();

        ListIterator c1 = l1.listIterator();
        ListIterator c2 = l2.listIterator();
        ListIterator c3 = head.listIterator();
        int sum = 0;

        while (c1.hasNext() || c2.hasNext()){
            sum /= 10;                //取整，
            if(c1.hasNext()){
                sum += (int)c1.next();
            }
            if(c2.hasNext()){
                sum += (int)c2.next();
            }
            c3.add(sum % 10);
        }

        if(sum / 10 == 1){     //循环结束后，判断最高位是否进1
            c3.add(1);
        }

        return head;

    }
}
