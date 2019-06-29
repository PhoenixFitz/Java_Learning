package stage.two.klaus;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Equations are given in the format A / B = k, where A and B are variables represented as strings,
 * and k is a real number (floating point number). Given some queries, return the answers. If the answer does not exist, return -1.0.
 *
 * Example:
 * Given a / b = 2.0, b / c = 3.0.
 * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
 * return [6.0, 0.5, -1.0, 1.0, -1.0 ].
 *
 * The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries ,
 * where equations.size() == values.size(), and the values are positive. This represents the equations. Return vector<double>.
 *
 * According to the example above:
 *
 * equations = [ ["a", "b"], ["b", "c"] ],
 * values = [2.0, 3.0],
 * queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
 */
public class EvaluateDivision {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<String>> pairs = new HashMap<>();
        Map<String, List<Double>> valuePairs = new HashMap<>();
        for(int i = 0; i < values.length; i++){
            List<String> list = equations.get(i);
            if(!pairs.containsKey(list.get(0))){
                pairs.put(list.get(0),new ArrayList<String>());
                valuePairs.put(list.get(0), new ArrayList<Double>());
            }
            if(!pairs.containsKey(list.get(1))){
                pairs.put(list.get(1),new ArrayList<String>());
                valuePairs.put(list.get(1),new ArrayList<Double>());
            }
            pairs.get(list.get(0)).add(list.get(1));
            pairs.get(list.get(1)).add(list.get(0));
            valuePairs.get(list.get(0)).add(values[i]);
            valuePairs.get(list.get(1)).add(1.0 / values[i]);
        }

        double[] res = new double[queries.size()];
        for(int i = 0; i < queries.size();i++){
            List<String> query = queries.get(i);
            res[i] = dfs(query.get(0),query.get(1),pairs,valuePairs, new HashSet<String>(), 1.0);
            if ((res[i] == 0.0))
                res[i] = -1.0;
        }
        return res;
    }

    public double dfs(String start, String end, Map<String, List<String>> pairs, Map<String,List<Double>> values, Set<String> set, double value){
        if(set.contains(start))
            return 0.0;
        if(!pairs.containsKey(start))
            return 0.0;
        if(start.equals(end))
            return value;
        set.add(start);   // set 集合保存访问标记，防止死循环

        List<String> strList = pairs.get(start);
        List<Double> valueList = values.get(start);
        double temp = 0.0;
        for(int i = 0; i < strList.size(); i++){
            temp = dfs(strList.get(i), end, pairs, values, set, value * valueList.get(i));
            if (temp != 0.0){
                break;
            }
        }

        return temp;
    }
}
