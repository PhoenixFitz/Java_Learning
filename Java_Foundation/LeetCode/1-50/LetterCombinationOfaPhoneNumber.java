package leetcode.klaus;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 * Example:
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationOfaPhoneNumber {

    public static void main(String[] args){

        String te = "232";
        System.out.println(letterCombination(te));

    }

    public static List<String> letterCombination(String digits){
        Map<Integer,String> map = new HashMap<>();
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
        List<String> result = new ArrayList<>();
        result.add("");

        for(char c: digits.toCharArray()){  //char[] toCharArray​() 将此字符串转换为新的字符数组。
            result = expand(result,map.get(c - '0'));
        }

        return result;
    }

    public static List<String> expand(List<String> list,String str){
        List<String> res = new ArrayList<>();
        for (String temp : list){
            for(char c : str.toCharArray()){
                res.add(temp + c);
            }
        }
        return res;
    }
}
