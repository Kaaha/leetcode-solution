/*
public class Interval {
    int start;
    int end;
    Interval() {start=0;end=0;}
    Interval(int s,int e) {start=s;end=e;}
}
*/
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> ans=new LinkedList<>();
        Collections.sort(intervals,new Comparator<Interval>() {
            public int compare(Interval a,Interval b) {
                if(a.start<b.start) return -1;
                else if(a.start==b.start) {
                    if(a.start<b.start) return -1;
                    else if(a.end==b.end) return 0;
                    else return 1;
                }
                else return 1;
            } 
        });
        while(intervals.size()>0) {
            if(intervals.size()==1) {
                ans.add(intervals.get(0));
                break;
            }
            Interval a=intervals.get(0);
            Interval b-intervals.get(1);
            if(a.end<b.start) {
                ans.add(a);
                intervals.remove(0);
                continue;
            }
            Interval t=merge(a,b);
            intervals.remove(0);
            intervals.set(0,t);
        }
        return ans;
    }
    private Interval merge(Interval a,Interval b) {
        return  new Interval(a.start,Math.max(a.end,b.end));
    }
}
