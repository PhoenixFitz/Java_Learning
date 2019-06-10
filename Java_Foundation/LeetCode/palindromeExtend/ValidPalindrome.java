package leetcode.klaus;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 *
 * Example 1:
 *
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 * Example 2:
 *
 * Input: "race a car"
 * Output: false
 */
public class ValidPalindrome {

    public boolean isPalindrome(String s){
        if(s == null)
            return true;
        int left = 0, right = s.length() - 1;
        while(left <= right){
            if(!isAlphaNum(s.charAt(left)))
                left++;
            else if(!isAlphaNum(s.charAt(right)))
                right--;
            //统一处理大小写字母的情况，因为小写字母比其对应的大写字母的ASCII码大32，所以如果遇到了大写字母，我们需要先加上32，
                // 然后再减去'a'，就知道其相对于'a'的位置了，这个值肯定是小于32的，所以对32取余没啥影响。
                //如果遇到小写字母，虽然加上了32，但是最后对32取余了，多加的32也就没了，所以还是能得到其相对于'a'的正确位置。
            else if((s.charAt(left) + 32 - 'a') % 32 != (s.charAt(right) + 32 - 'a') % 32)
                return false;
            else{
                left++;
                right--;
            }
        }
        return true;
    }

    public boolean isAlphaNum(char ch){
        if(ch >= 'a' && ch <='z')
            return true;
        if(ch >= '0' && ch <= '9')
            return true;
        if(ch >= 'A' && ch <= 'Z')
            return true;
        return false;
    }

    //直接调用判断是否是字母、数字的java方法
    public boolean siPalindrome02 (String s){
        if(s.isEmpty())
            return true;
        int left = 0, right = s.length() - 1;
        char cLeft,cRight;
        while(left <= right){
            cLeft = s.charAt(left);
            cRight = s.charAt(right);
            if(!Character.isLetterOrDigit(cLeft))
                left++;
            else if(!Character.isLetterOrDigit(cRight))
                right--;
            else if(Character.toLowerCase(cLeft) != Character.toLowerCase(cRight))
                return false;
            else{
                left++;
                right--;
            }
        }
        return true;
    }

}
