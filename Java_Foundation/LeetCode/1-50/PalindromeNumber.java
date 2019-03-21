package stage.one.klaus;

/**
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 */
public class PalindromeNumber {

    public static void main(String[] args){
        int t = 1000;
        System.out.println(isPalindrome03(t));

    }

    public static boolean isPalindrome(int x){
        int rightnum = 0;
        // Special cases:
        // As discussed above, when x < 0, x is not a palindrome.
        // Also if the last digit of the number is 0, in order to be a palindrome,
        // the first digit of the number also needs to be 0.
        // Only 0 satisfy this property.
        if(x < 0 || (x % 10 == 0 && x != 0)){
            return false;
        }
        while(x > rightnum){
            rightnum = rightnum * 10 + x % 10;
            x = x / 10;
        }
        // When the length is an odd number, we can get rid of the middle digit by revertedNumber/10
        // For example when the input is 12321, at the end of the while loop we get x = 12, revertedNumber = 123,
        // since the middle digit doesn't matter in palidrome(it will always equal to itself), we can simply get rid of it.
        return x == rightnum || x == rightnum / 10;
    }

    public static boolean isPalindrome02(int x){
        String str = Integer.toString(x);
        String reverse = new StringBuffer(str).reverse().toString();
        return str.equalsIgnoreCase(reverse);
    }

    public static boolean isPalindrome03(int x){
        int rev = 0;
        int temp = x;
        if(temp < 0){
            return false;
        }
        while(temp > 0){
            rev = rev * 10 + temp % 10;
            temp = temp / 10;
        }

        return rev == x;

    }
}
