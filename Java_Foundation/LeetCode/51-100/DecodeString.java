package stage.two.klaus;

import java.util.Stack;

/**
 * Given an encoded string, return its decoded string.
 *
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 *
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 *
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
 *
 * Examples:
 *
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 */
public class DecodeString {

    //用 stack 来辅助运算，我们用两个 stack，一个用来保存个数，一个用来保存字符串，我们遍历输入字符串，如果遇到数字，我们更新计数变量 cnt；
    // 如果遇到左括号，我们把当前 cnt 压入数字栈中，把当前t压入字符串栈中；如果遇到右括号时，我们取出数字栈中顶元素，存入变量k，
    // 然后给字符串栈的顶元素循环加上k个t字符串，然后取出顶元素存入字符串t中；如果遇到字母，我们直接加入字符串t中即可
    public String decodeString(String s){
        String res = "";
        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        int idx = 0;
        while(idx < s.length()){
            if(Character.isDigit(s.charAt(idx))){
                int count = 0;
                while(Character.isDigit(s.charAt(idx))){
                    count = count * 10 + (s.charAt(idx) - '0');
                    idx++;
                }
                numStack.push(count);
            }else if(s.charAt(idx) == '['){
                strStack.push(res);
                idx++;
                res = "";
            }else if(s.charAt(idx) == ']'){
                StringBuilder temp = new StringBuilder(strStack.pop());
                int repeat = numStack.pop();
                while(repeat > 0){
                    temp.append(res);
                    repeat--;
                }
                res = temp.toString();
                idx++;
            }else{
                res += s.charAt(idx);
                idx++;
            }
        }
        return res;

    }

}
