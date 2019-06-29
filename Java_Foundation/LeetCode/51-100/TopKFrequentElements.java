package stage.two.klaus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {

    public List<Integer> topKFrequent(int[] nums, int k){
        List<Integer>[] lists = new List[nums.length + 1];
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num,map.getOrDefault(num, 0) + 1);
        }

        for(int key : map.keySet()){
            int frequency = map.get(key);
            if(lists[frequency] == null){
                lists[frequency] = new ArrayList<>();
            }
            lists[frequency].add(key);
        }
        List<Integer> res = new ArrayList<>();

        for(int i = lists.length - 1; i >= 0 && res.size() < k; i--){
            if (lists[i] != null){
                res.addAll(lists[i]);
            }
        }
        while(res.size() > k){
            res.remove(res.size() - 1);
        }
        return res;
    }

}
