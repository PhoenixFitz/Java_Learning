package stage.extend.klaus.palindrome;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return the minimum cuts needed for a palindrome partitioning of s.
 *
 * Example:
 *
 * Input: "aab"
 * Output: 1
 * Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
 */
public class PalindromePartitioning02 {

    /**
     * DP解法的两个步骤，定义dp数组和找状态转移方程。首先来定义dp数组，这里使用最直接的定义方法，一维的dp数组，其中dp[i]表示子串 [0, i] 范围内的最小分割数，
     * 那么我们最终要返回的就是 dp[n-1] 了，这里先加个corner case的判断，若s串为空，直接返回0，OJ的test case中并没有空串的检测，但还是加上比较好，
     * 毕竟空串也算是回文串的一种，所以最小分割数为0也说得过去。
     *
     * dp[i]表示子串 [0, i] 范围内的最小分割数。那么这个区间的每个位置都可以尝试分割开来，所以就用一个变量j来从0遍历到i，这样就可以把区间 [0, i] 分为两部分，
     * [0, j-1] 和 [j, i]，那么suppose我们已经知道区间 [0, j-1] 的最小分割数 dp[j-1]，因为我们是从前往后更新的，而 j 小于等于 i，所以 dp[j-1] 肯定在 dp[i]
     * 之前就已经算出来了。这样我们就只需要判断区间 [j, i] 内的子串是否为回文串了，是的话，dp[i] 就可以用 1 + dp[j-1] 来更新了。
     *
     * 第一个for循环遍历的是i，此时我们现将 dp[i] 初始化为 i，因为对于区间 [0, i]，就算我们每个字母割一刀（怎么听起来像凌迟？！），最多能只用分割 i 次，
     * 不需要再多于这个数字。但是可能会变小，所以第二个for循环用 j 遍历区间 [0, j]，根据上面的解释，我们需要验证的是区间 [j, i] 内的子串是否为回文串，
     * 那么只要 s[j] == s[i]，并且 i-j < 2 或者 p[j+1][i-1] 为true的话，先更新 p[j][i] 为true，然后在更新 dp[i]，这里需要注意一下corner case，当 j=0 时，
     * 我们直接给 dp[i] 赋值为0，因为此时能运行到这，说明 [j, i] 区间是回文串，而 j=0， 则说明 [0, i] 区间内是回文串，这样根本不用分割啊。若 j 大于0，
     * 则用 dp[j-1] + 1 来更新 dp[i]，最终返回 dp[n-1] 即可，
     */
    public int minCut(String s) {
        if(s.length() == 0)
            return 0;
        int n = s.length();
        int[] dp = new int[n];
        boolean[][] p = new boolean[n][n];
        for(int i = 0; i < n; i++){
            dp[i] = i;
            for(int j = 0; j <= i; j++){
                if(s.charAt(i) == s.charAt(j) && (i - j <= 2 || p[j + 1][i - 1])){ //判断[j,i]字串是否是回文串
                    p[j][i] = true;
                    dp[i] = (j == 0) ? 0 : Math.min(dp[i],dp[j - 1] + 1); // [0, i] 分为两部分，[0, j-1] 和 [j, i]
                }
            }
        }

        return dp[n - 1];


    }

    /**
     * 下面这种解法是论坛上的高分解法，没用使用判断区间 [i, j] 内是否为回文串的二维dp数组，节省了空间。但写法上比之前的解法稍微有些凌乱，也算是个 trade-off 吧。
     * 这里还是用的一维dp数组，不过大小初始化为了 n+1，这样其定义就稍稍发生了些变化，dp[i] 表示由s串中前 i 个字母组成的子串的最小分割数，这样 dp[n] 极为最终所求。
     * 接下来就要找状态转移方程了。这道题的更新方式比较特别，跟之前的都不一样，之前遍历 i 的时候，都是更新的 dp[i]，这道题更新的却是 dp[i+len+1] 和 dp[i+len+2]，
     * 其中 len 是以i为中心，总长度为 2*len + 1 的回文串，比如 bob，此时 i=1，len=1，或者是i为中心之一，总长度为 2*len + 2 的回文串，比如 noon，此时 i=1，
     * len=1。中间两个for循环就是分别更新以 i 为中心且长度为 2*len + 1 的奇数回文串，和以 i 为中心之一且长度为 2*len + 2 的偶数回文串的。
     * i-len 正好是奇数或者偶数回文串的起始位置，由于我们定义的 dp[i] 是区间 [0, i-1] 的最小分割数，所以 dp[i-len] 就是区间 [0, i-len-1] 范围内的最小分割数，
     * 那么加上奇数回文串长度 2*len + 1，此时整个区间为 [0, i+len]，即需要更新 dp[i+len+1]。如果是加上偶数回文串的长度 2*len + 2，那么整个区间为 [0, i+len+1]，
     * 即需要更新 dp[i+len+2]。这就是分奇偶的状态转移方程，
     */
    public int minCut02(String s){
        if(s.length() == 0)
            return 0;
        int n = s.length();
        int[] dp = new int[n + 1];
        for(int i = 0; i < n + 1; i++)
            dp[i] = Integer.MAX_VALUE;
        dp[0] = -1;
        for(int i = 0; i < n; i++){
            for(int len = 0; i - len >= 0 && i + len < n && s.charAt(i - len) == s.charAt(i + len); len++){ //中心为奇数
                // dp[i-len] 就是区间 [0, i-len-1] 范围内的最小分割数，那么加上奇数回文串长度 2*len + 1，此时整个区间为 [0, i+len]，即需要更新 dp[i+len+1]
                dp[i + len + 1] = Math.min(dp[i + len + 1], dp[i - len] + 1);
            }
            for(int len = 0; i - len >=0 && i + len + 1 < n && s.charAt(i - len) == s.charAt(i + len + 1); len++){ //中心为偶数
                //加上偶数回文串的长度 2*len + 2，那么整个区间为 [0, i+len+1]，即需要更新 dp[i+len+2]
                dp[i + len + 2] = Math.min(dp[i + len + 2], dp[i - len] + 1);
            }
        }
        return dp[n];
    }
}
