/*
public class Interval {
    int start;
    int end;
    Interval() {start=0;end=0;}
    Interval(int s,int e) {start=s;end=e;}
}
*/
public class Solution {
    public List<Interval> insert(List<Interval> intervals,Interval newInterval) {
        List<Interval> ans=new ArrayList<>();
        Interval curr=new Interval(newInterval.start,newInterval.end);
        for(Interval interval:intervals) {
            if(interval.end<curr.start) {
                ans.add(interval);
                if(intervals.indexOf(interval)==intervals.size()-1) ans.add(curr);
            }else if(curr.end<interval.start) {
                if(ans.indexOf(curr)==-1) ans.add(curr);
                ans.add(interval);
            }else {
                curr.start=Math.min(interval.start,curr.start);
                curr.end=Math.max(interval.end,curr.end);
                if(intervals.indexOf(interval)==intervals.size()-1) ans.add(curr);
            }
        }
        return ans;
    }
}
