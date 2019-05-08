package stage.one.klaus;

import java.util.*;

public class WordBreak {
    public static void main(String[] args){

    }


    //brute force, recurse
    public boolean wordBreak(String s, List<String> wordDict){
        Map<Integer,Boolean> map = new HashMap<>();// 是否可拆分标记，保存[i,s.length - 1]范围的子字符串是否可拆分，如果可以拆分，则赋值为1
        Set<String> set = new HashSet<>();
        for(String str : wordDict)
            set.add(str);
        return check(0, s, set, map);
    }

    public boolean check(int start, String s, Set<String> setDict, Map<Integer,Boolean> map){
        if(start >= s.length())
            return true;
        if(map.containsKey(start) && map.get(start) == true )
            return true;
        for(int i = start + 1; i <= s.length(); i++){
            if(setDict.contains(s.substring(start, i)) && check(i, s, setDict, map)){
                map.put(start, true);
                return true;
            }

        }

        return false;
    }

    //动态规划
    //dp[i]表示范围[0, i)内的子串是否可以拆分，注意这里dp数组的长度比s串的长度大1，是因为我们要handle空串的情况，我们初始化memo[0]为true，
    // 然后开始遍历。注意这里我们需要两个for循环来遍历，因为此时已经没有递归函数了，所以我们必须要遍历所有的子串，
    // 我们用j把[0, i)范围内的子串分为了两部分，[0, j) 和 [j, i)，其中范围 [0, j) 就是memo[j]，范围 [j, i) 就是s.substr(j, i-j)，
    // 其中memo[j]是之前的状态，我们已经算出来了，可以直接取，只需要在字典中查找s.substr(j, i-j)是否存在了，
    // 如果二者均为true，将memo[i]赋为true，并且break掉，此时就不需要再用j去分[0, i)范围了，因为[0, i)范围已经可以拆分了。
    // 最终我们返回dp数组的最后一个值，就是整个数组是否可以拆分的布尔值了
    public boolean wordBreak02(String s, List<String> wordDict){
        Set<String> set = new HashSet<>();
        for(String str : wordDict)
            set.add(str);
        boolean[] memo = new boolean[s.length() + 1];
        memo[0] = true;
        for(int i = 0; i <= s.length(); i++)
            for(int j = 0; j < i; j++){
                if(memo[j] && set.contains(s.substring(j, i))){
                    memo[i] = true;
                    break;
                }
            }
        return memo[s.length()];
    }

}
