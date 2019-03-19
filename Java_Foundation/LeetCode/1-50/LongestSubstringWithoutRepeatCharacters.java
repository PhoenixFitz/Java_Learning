package stage.one.klaus;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 *Example 1:
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatCharacters {

    public static void main (String[] args){
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring03(s));
    }


    //暴力法
    public static int lengthOfLongestSubstring(String s) {

        int l = s.length();
        int ans = 0;
        for(int i = 0; i < l; i++){
            for(int j = i+1; j <= l; j++){
                if(compare(s,i,j))
                    ans = Math.max(ans,j-i);
            }
        }
        return ans;
    }

    public static boolean compare(String s, int i , int j){
        Set<Character> set = new HashSet<>();
        for (int x = i; x < j; x++){
            Character ch = s.charAt(x);
            if(set.contains(ch)){
                return false;
            }

            set.add(ch);
        }
        return true;
    }

    //Sliding Window
    /**
     * A sliding window is an abstract concept commonly used in array/string problems.
     * A window is a range of elements in the array/string which usually defined by the start and end indices, i.e. [i, j)[i,j)
     * A sliding window is a window "slides" its two boundaries to the certain direction. For example,
     * if we slide [i, j)[i,j) to the right by 11 element, then it becomes [i+1, j+1)[i+1,j+1)
     */

    public static int lengthOfLongestSubstring02(String s){

        int n = s.length();
        Set<Character> set = new HashSet<>();
        int i = 0, j = 0, ans = 0;
        while(i < n && j < n){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
                ans = Math.max(ans,j-i);
            }else{
                set.remove(s.charAt(i));
                i++;
            }
        }
        return ans;
    }


    //sliding window optimized

    public static int lengthOfLongestSubstring03(String s){
        if(s.length() == 0){
            return 0;
        }
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        int n = s.length();
        int max = 0;
        for(int i = 0, j= 0; j < n; j++){
            if(map.containsKey(s.charAt(j))){  // 判断map中是否有该字符
                i = Math.max(i, map.get(s.charAt(j))+1);   //若有，则从重复字符的下一个位置开始寻找子串
            }
            map.put(s.charAt(j), j);
            max = Math.max(max, j-i+1);

        }
        return max;

    }
}

