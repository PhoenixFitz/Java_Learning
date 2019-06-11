package stage.extend.klaus.palindrome;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example 1:
 *
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: "cbbd"
 * Output: "bb"
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s){
        if(s.length() < 2)
            return s;
        int maxLen = 0;
        int start = 0;
        int n = s.length();
        for(int i = 0; i < n;){
            if(n - i <= maxLen/2)
                break;
            int left = i, right = i;
            while(right < n -1 && s.charAt(right) == s.charAt(right + 1))
                right++;
            i = right + 1;
            while(right < n - 1 && left > 0 && s.charAt(right + 1) == s.charAt(left - 1)){
                right++;
                left--;
            }
            if(maxLen < right - left + 1) {
                maxLen = right - left + 1;
                start = left;
            }

        }
        return s.substring(start,start + maxLen);
    }

    //dynamic programming

    public String longestPalindrome02(String s){
        if (s.length() < 2)
            return s;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int len = 0, right = 0, left = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                dp[j][i] = (s.charAt(j) == s.charAt(i) && (i - j <= 2 || dp[j + 1][i - 1]));
                if(dp[j][i] && len < i - j + 1){
                    left = j;
                    right = i;
                    len = i - j + 1;
                }
            }
        }
        return s.substring(left, right + 1);

    }
}
