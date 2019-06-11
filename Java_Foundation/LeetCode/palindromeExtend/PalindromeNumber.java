package stage.extend.klaus.palindrome;

/**
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 *
 * Example 1:
 *
 * Input: 121
 * Output: true
 * Example 2:
 *
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 *
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 */
public class PalindromeNumber {

    //直接对整数进行操作，我们可以利用取整和取余来获得我们想要的数字，比如 1221 这个数字，如果 计算 1221 / 1000， 则可得首位1，
    // 如果 1221 % 10， 则可得到末尾1，进行比较，然后把中间的22取出继续比较。

    public boolean isPalindrome(int x){
        if(x < 0)
            return false;
        int div = 1;
        while(x / 10 >= div)
            div = div * 10;
        while(x > 0){
            int left = x / div;
            int right= x % 10;
            if(left != right)
                return false;
            x = (x % div) / 10;
            div = div / 100;
        }
        return true;

    }

    /**
     * 看前后半段是否对称，如果把后半段翻转一下，就看和前半段是否相等就行了。所以我们的做法就是取出后半段数字，进行翻转，具体做法是，
     * 每次通过对10取余，取出最低位的数字，然后加到取出数的末尾，就是将revertNum乘以10，再加上这个余数，这样我们的翻转也就同时完成了，
     * 每取一个最低位数字，x都要自除以10。这样当revertNum大于等于x的时候循环停止。由于回文数的位数可奇可偶，如果是偶数的话，
     * 那么revertNum就应该和x相等了；如果是奇数的话，那么最中间的数字就在revertNum的最低位上了，我们除以10以后应该和x是相等的，
     */
    public boolean isPalindrome02(int x){
        if(x < 0 || (x % 10 == 0 && x !=0))
            return false;
        int rev = 0;
        while(x > rev){
            rev = rev * 10 + x % 10;
            x = x / 10;
        }
        return x == rev || x == rev / 10;
    }

    /**
     * 如果是palindrome，反转后仍是原数字，就不可能溢出，只要溢出一定不是palindrome返回false就行。
     */
    public boolean isPalindrome03(int x){
        if(x < 0 || (x % 10 == 0 && x != 0))
            return false;
        int rev = reverse(x);
        return rev == x;
    }

    public int reverse(int x){
        int rev = 0;
        while(x > 0){
            if(rev > Integer.MAX_VALUE / 10)
                return -1;
            rev = rev * 10 + x % 10;
            x = x / 10;
        }
        return rev;
    }
}

