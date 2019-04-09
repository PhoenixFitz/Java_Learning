package stage.one.klaus;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Note: Given n will be a positive integer.
 *
 * Example 2:
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 */
public class ClimbingStairs {

    public static void main(String[] args){
        System.out.println(climbStairs(3));
    }

    /**
     * As we can see this problem can be broken into subproblems, and it contains the optimal substructure property i.e.
     * its optimal solution can be constructed efficiently from optimal solutions of its subproblems,
     * we can use dynamic programming to solve this problem.
     *
     * One can reach i step in one of the two ways:
     * 1、Taking a single step from (i-1) step.
     * 2、Taking a step of 22 from (i-2) step。
     *
     * So, the total number of ways to reach i is equal to sum of ways of reaching (i-1) step and ways of reaching (i-2) step.
     *
     * Let dp[i] denotes the number of ways to reach on i step:
     * dp[i] = dp[i - 1] + dp[i - 2]
     */
    public static int climbStairs(int n){
        if(n == 1)
            return 1;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++)
            dp[i] = dp[i - 1] + dp[i - 2];
        return dp[n];
    }
}
