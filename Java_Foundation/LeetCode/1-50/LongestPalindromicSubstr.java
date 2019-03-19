package stage.one.klaus;


/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example 1:
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 *
 * Example 2:
 * Input: "cbbd"
 * Output: "bb"
 */
public class LongestPalindromicSubstr {

    public static void main(String[] args){
        String str = "";
        String str1 = "cbbdac";
        String str2 = "babadcfgf";
        System.out.println(longestPalindrome(str2));



    }

    public static String longestPalindrome(String s){
        if(s == ""){
            return "";
        }
        int start = 0;
        int end = 0;
        for(int i = 0; i < s.length(); i++){
            int len1 = isPalindromicString(s, i, i);
            int len2 = isPalindromicString(s, i, i+1);
            int len = Math.max(len1, len2);
            if(len > end - start){   //如果有多个最长子串， 会返回最后那个
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end+1);  //  substring(a,b), 返回的子串是 [a,b)

    }

    private static int isPalindromicString(String s, int left, int right){

        while(left >= 0 && right < s.length() && (s.charAt(left)==s.charAt(right))){
            left--;
            right++;
        }

        return right - left -1;
    }
}
