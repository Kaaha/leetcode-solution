public class Solution {
    public int mySqrt(int x) {
        if(x<0) return x;
        int lo=0,hi=43461;
        while(lo<hi-1) {
            int mid=(lo+hi)/2;
            if(mid*mid<x) lo=mid;
            else if(mid*mid>x) hi=mid;
            else return mid;
        }
        return lo;
    }
}
