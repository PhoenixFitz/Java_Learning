package stage.one.klaus;

/**
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found.
 * Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible,
 * and interprets them as a numerical value.
 *
 * The string can contain additional characters after those that form the integral number,
 * which are ignored and have no effect on the behavior of this function.
 *
 * If the first sequence of non-whitespace characters in str is not a valid integral number,
 * or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
 *
 * If no valid conversion could be performed, a zero value is returned.
 */
public class String2Integer {

    public static void main(String [] args){
        String s = "  156454984";
        System.out.println(myAtoi(s));
    }

    public static int myAtoi(String str){
        int flag = 1, index = 0, result = 0;
        //1.empty string
        if(str.length() == 0){
            return 0;
        }
        //2. Remove spaces
        while(index < str.length() && str.charAt(index) == ' '){
            index ++;
        }
        //3. judgement of positive and negative
        if(index < str.length() && (str.charAt(index) == '+' || str.charAt(index) == '-')){
            flag = (str.charAt(index) == '+' ? 1 : -1);
            index ++ ;
        }
        //4. convert number and avoid overflow
        while(index < str.length()){
            int tail = str.charAt(index) - '0';
            if(tail < 0 || tail > 9){   //not 0-9,  stop loop
                break;
            }

            //check if total will be overflow after 10 times and add digit
            if(result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && tail > Integer.MAX_VALUE % 10)){
                return flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + tail;
            index ++;
        }
        return result*flag;
    }
}
