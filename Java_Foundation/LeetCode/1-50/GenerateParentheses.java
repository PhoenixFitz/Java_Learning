package leetcode.klaus;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 *["((()))","(()())","(())()","()(())","()()()"]
 */
public class GenerateParentheses {

    public static void main(String[] args){
        List<String> test = new ArrayList<>();
        test = generateParenthesis(3);
        System.out.println(test);

    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        addParentheses(result,"", 0, 0, n);
        return result;
    }

    public static void addParentheses(List<String> list, String cur, int left,
                               int right, int max){
        if(cur.length() == max * 2){
            list.add(cur);
        }
        if(left < max){
            addParentheses(list, cur + "(",left + 1, right, max);
        }
        if(right < left){
            addParentheses(list, cur + ")",left, right + 1, max);
        }
    }
}
