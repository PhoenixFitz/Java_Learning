package stage.one.klaus;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatCharacters {

    public static void main (String[] args){
        String s = "kialsksul";
        System.out.println(lengthOfLongestSubstring02(s));
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
}

