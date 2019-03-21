package stage.one.klaus;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−2^31,  2^31 − 1].
 * For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 *
 * <<  :  左移运算符，num << 1,相当于num乘以2
 * >>  :  右移运算符，num >> 1,相当于num除以2
 */
public class ReverseInteger {

    public static void main(String[] args){
        int i = 1534236469;
        System.out.println(reverse(i));
    }

    public static int reverse(int x){
        int rev = 0;
        while(x != 0){
            int tail = x % 10;
            x = x / 10;
            if(rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && tail > Integer.MAX_VALUE % 10)){ // 判断int是否溢出；或tail > 7
                return 0;
            }
            if(rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && tail < Integer.MIN_VALUE % 10)){ //或 tail < -8
                return 0;
            }
            rev = rev * 10 + tail;
        }
        return rev;
    }
}
