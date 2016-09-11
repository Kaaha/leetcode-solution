public class Solution {
    public double myPow(double x,int n) {
        double ans=1;
        long N=Math.abs((long)n);
        while(N>0) {
            if((N&1)==1) ans*=x;
            N=N>>1;
            x*=x;
        }
        return n>0?ans:1/ans;
    }
}
