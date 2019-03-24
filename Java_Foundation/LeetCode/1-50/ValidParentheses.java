package leetcode.klaus;
/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 * 1.Open brackets must be closed by the same type of brackets.
 * 2.Open brackets must be closed in the correct order.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args){
        String s = "(){}[[]])";
        System.out.println(isValid02(s));
    }

    public boolean isValid(String s) {
        // Initialize hash map with mappings. This simply makes the code easier to read.
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {// If the current character is a closing bracket.
                // Get the top element of the stack. If the stack is empty, set a dummy value of '#'
                char topElement = stack.isEmpty() ? '#' : stack.pop();
                // If the mapping for this bracket doesn't match the stack's top element, return false.
                if (map.get(c) != topElement)
                    return false;
            } else {
                // If it was an opening bracket, push to the stack.
                stack.push(c);
            }
        }
        // If the stack still contains elements, then it is an invalid expression.
        return stack.isEmpty();
    }

    public static boolean isValid02(String s){
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '('){
                stack.push(')');
            }else if( c == '['){
                stack.push(']');
            }else if(c == '{'){
                stack.push('}');
            }else if(stack.isEmpty() || c != stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}


