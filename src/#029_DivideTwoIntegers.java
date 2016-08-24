public class Solution {
    public int divide(int dividend,int divisor) {
        if(dividend==Integer.MIN_VALUE && divisor==-1 || divisor==0)
            return Integer.MAX_VALUE;
        long divd=Math.abs((long)dividend);
        long divs=Math.abs((long)divisor);
        int ans=0;
        while(divd>=divs) {
            long temp=divs;
            int mult=1;
            while(divd>=(temp<<1)) {
                temp=temp<<1;
                mult=mult<<1;
            }
            divd-=temp;
            ans+=mult;
        }
        return ((dividend>0) ^ (divisor>0))?-ans:ans;
    }
}
