package stage.one.klaus;
/**
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * Example 1:
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 */

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args){

    }

    class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    class IntervalComparator implements Comparator<Interval> {

        @Override
        public int compare(Interval a, Interval b) {
            return a.start < b.start ? -1 : a.start == b.start ? 0 : 1;
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        //或者用lambda表达式
        //(Interval a, Interval b)->{return a.start < b.start ? -1 : a.start == b.start ? 0 : 1;}
        Collections.sort(intervals, new IntervalComparator());

        LinkedList<Interval> merged = new LinkedList<Interval>();
        for(Interval interval : intervals){
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if(merged.isEmpty() || merged.getLast().end < interval.start){
                merged.add(interval);
            }
            // otherwise, there is overlap, so we merge the current and previous intervals.
            else{
                merged.getLast().end = Math.max(merged.getLast().end, interval.end);
            }
        }
        return merged;
    }
}
