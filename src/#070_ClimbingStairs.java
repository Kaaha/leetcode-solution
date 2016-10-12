public class Solution {
    public int climbStairs(int n) {
        if(n<=0) return 1;
        int a=0,b=1;
        int i=0,ans=0;
        while(i<n) {
            ans=a+b;
            a=b;
            b=ans;
            i++;
        }
        return ans;
    }
}
