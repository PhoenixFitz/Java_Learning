package stage.one.klaus;

import java.util.*;

/**
 * Given an array of strings, group anagrams together.
 *
 * Example:
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 *
 * Note:
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 */
public class GroupAnagrams {


    public static void main(String[] args){
        String[] strings = new String[]{"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strings));
    }
    /**
     * Maintain a map ans : {String -> List} where each key K is a sorted string,
     * and each value is the list of strings from the initial input that when sorted, are equal to K.
     *
     * In Java, we will store the key as a string
     */

    public static List<List<String>> groupAnagrams(String[] strs){
        List<List<String>> ans = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        if(strs.length == 0)
            return ans;
        for(String str : strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);            //对每个字符数组进行排序， 含有相同字母的字符数组等于map中的key
            String key = Arrays.toString(chars);  //String.valueOf(chars); 也可以转化为字符串
            if(!map.containsKey(key))
                map.put(key, new ArrayList<String>());
            map.get(key).add(str);
        }
        for(List<String> list : map.values())    //或者  return new ArrayList(ans.values());
            ans.add(list);
        return ans;
    }
}
