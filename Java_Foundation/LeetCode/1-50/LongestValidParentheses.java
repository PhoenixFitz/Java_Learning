package stage.one.klaus;

import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 *
 * Example 1:
 * Input: "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()"
 *
 * Example 2:
 * Input: ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()"
 */
public class LongestValidParentheses {

    public static void main(String[] args){
        String str = ")()())";
        System.out.println(longestValidParentheses(str));

    }

    public static int longestValidParentheses(String s){
        Stack<Integer> stack = new Stack<>();
        int maxValue = 0;
        stack.push(-1);  // 避免空栈,存储有效子串起始位的前一位置的索引
        for (int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }else{
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    maxValue = Math.max(maxValue, i - stack.peek());
                }
            }
        }
        return maxValue;
    }
}
