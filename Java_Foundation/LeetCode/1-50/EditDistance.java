package stage.one.klaus;

/**
 * Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
 *
 * You have the following 3 operations permitted on a word:
 * Insert a character
 * Delete a character
 * Replace a character
 *
 * Example 1:
 *
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation:
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 */
public class EditDistance {
    public static void main(String[] args){
        System.out.println(minDistance("ss", "sdasd"));
    }

    /**
     * 在比较的时候，要尝试三种操作，因为谁也不知道当前的操作会对后面产生什么样的影响，那么对于当前比较的两个字符 word1[i] 和 word2[j]，
     * 若二者相同，一切好说，直接跳到下一个位置。若不相同，有三种处理方法，首先是直接插入一个 word2[j]，那么 word2[j] 位置的字符就跳过了
     * ，接着比较 word1[i] 和 word2[j+1] 即可。第二个种方法是删除，即将 word1[i] 字符直接删掉，接着比较 word1[i+1] 和 word2[j] 即可。
     * 第三种则是将 word1[i] 修改为 word2[j]，接着比较 word1[i+1] 和 word[j+1] 即可。
     * 我们可以直接写出递归的代码，但是很可惜会 Time Limited Exceed，所以我们必须要优化事件复杂度，需要去掉大量的重复计算，
     * 这里我们使用记忆数组 memo 来保存计算过的状态，从而可以通过OJ，注意这里的 insertCnt，deleteCnt，replaceCnt
     * 仅仅是表示当前对应的位置分别采用了插入，删除，和替换操作，整体返回的最小距离，后面位置的还是会调用递归返回最小的
     */
    //递归
    public static int minDistance(String word1, String word2) {
        int first = word1.length();
        int second = word2.length();
        int[][] memo = new int[first][second];
        return helper(word1, 0, word2, 0, memo);
    }

    public static int helper(String word1, int i, String word2, int j, int[][] memo){
        if(i == word1.length())
            return word2.length() - j;
        if(j == word2.length())
            return word1.length() - i;
        if(memo[i][j] > 0)
            return memo[i][j];
        int res = 0;
        if(word1.charAt(i) == word2.charAt(j))
            return helper(word1, i + 1, word2, j + 1, memo);
        else{
            int insertCnt = helper(word1, i, word2, j + 1, memo);
            int deleteCnt = helper(word1, i + 1, word2, j, memo);
            int replaceCnt = helper(word1, i + 1, word2, j + 1, memo);
            res = Math.min(insertCnt, Math.min(deleteCnt, replaceCnt)) + 1;
        }
        return memo[i][j] = res;
    }
    /**
     * 维护一个二维的数组dp，其大小为 mxn，m和n分别为 word1 和word2 的长度。dp[i][j] 表示从 word1 的前i个字符转换到 word2 的前j个字符所需要的步骤。
     * 那我们可以先给这个二维数组dp的第一行第一列赋值，这个很简单，因为第一行和第一列对应的总有一个字符串是空串，于是转换步骤完全是另一个字符串的长度。
     * 比如word1是“bbc"，word2是”abcd“，那么我们可以得到dp数组如下：
     *   Ø a b c d
     * Ø 0 1 2 3 4
     * b 1 1 1 2 3
     * b 2 2 1 2 3
     * c 3 3 2 1 2
     *
     * 通过观察可以发现，当word1[i] == word2[j]时，dp[i][j] = dp[i - 1][j - 1]，其他情况时，dp[i][j]是其左，左上，上的三个值中的最小值加1，
     * 其实这里的左，上，和左上，分别对应的增加，删除，修改操作，具体可以参见解法一种的讲解部分，那么可以得到状态转移方程为：
     * dp[i][j] =      /    dp[i - 1][j - 1]                                      if word1[i - 1] == word2[j - 1]
     *
     *                 \    min(dp[i - 1][j - 1], min(dp[i - 1][j], dp[i][j - 1])) + 1            else
     */
    //动态规划
    public static int minDistance02(String word1, String word2){
        int first = word1.length();
        int second = word2.length();
        int[][] dp = new int[first + 1][second + 1];
        for(int i = 0; i <= first; i++)
            dp[i][0] = i;
        for(int i = 0; i <= second; i++)
            dp[0][i] = i;
        for(int i = 1; i <= first; i++)
            for(int j = 1; j <= second; j++){
                if(word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else{
                    dp[i][j] = Math.min(dp[i - 1][j - 1],Math.min(dp[i - 1][j],dp[i][j - 1])) + 1;
                }
            }
        return dp[first][second];


    }

}
