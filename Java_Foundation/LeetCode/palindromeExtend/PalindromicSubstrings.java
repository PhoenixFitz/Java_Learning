package stage.extend.klaus.palindrome;

/**
 * Given a string, your task is to count how many palindromic substrings in this string.
 *
 * The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.
 *
 * Example 1:
 *
 * Input: "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 *
 *
 * Example 2:
 *
 * Input: "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 */
public class PalindromicSubstrings {
    /**
     * 这道题也可以用递归来做，而且思路非常的简单粗暴。就是以字符串中的每一个字符都当作回文串中间的位置，然后向两边扩散，每当成功匹配两个左右两个字符，
     * 结果res自增1，然后再比较下一对。注意回文字符串有奇数和偶数两种形式，如果是奇数长度，那么i位置就是中间那个字符的位置，所以我们左右两遍都从i开始遍历；
     * 如果是偶数长度的，那么i是最中间两个字符的左边那个，右边那个就是i+1，这样就能cover所有的情况啦，而且都是不同的回文子字符串
     */
    public int countSubstrings(String s) {
        if(s.length() == 0)
            return 0;
        int count = 0;
        for(int i = 0; i < s.length(); i++){

            count += helper(s, i, i);         //字串字符个数为奇数
            count += helper(s, i, i + 1); //字串字符个数为偶数
        }
        return count;


    }

    public int helper(String s, int left, int right){
        int count = 0;
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
            count++;
        }
        return count;
    }

    /**
     * dynamic programming
     * 将dp[i][j]定义成子字符串[i, j]是否是回文串就行了，然后我们i从n-1往0遍历，j从i往n-1遍历，然后我们看s[i]和s[j]是否相等，这时候我们需要留意一下，
     * 有了s[i]和s[j]相等这个条件后，i和j的位置关系很重要，如果i和j相等了，那么dp[i][j]肯定是true；如果i和j是相邻的，那么dp[i][j]也是true；
     * 如果i和j中间只有一个字符，那么dp[i][j]还是true；如果中间有多余一个字符存在，那么我们需要看dp[i+1][j-1]是否为true，若为true，那么dp[i][j]就是true。
     * 赋值dp[i][j]后，如果其为true，结果res自增1
     */
    public int countSubstrings02(String s){
        int n = s.length();
        int count = 0;
        boolean[][] dp = new boolean[n][n];
        for(int i = n - 1; i >= 0; i-- ){
            for(int j = i; j < n; j++){
                if(s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    count++;
                }
            }
        }
        return count;
    }

}
