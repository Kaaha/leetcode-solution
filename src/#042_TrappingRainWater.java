public class Solution {
    public int trap(int[] height) {
        int ans=0;
        int n=height.length;
        if(n==0) return ans;
        int maxLeft=height[0],maxRight=height[n-1];
        int i=0,j=n-1;
        while(i<=j) {
            maxLeft=Math.max(maxLeft,height[i]);
            maxRight=Math.max(maxRight,height[j]);
            if(maxLeft<maxRight) {
                ans+=maxLeft-height[i];
                i++;
            }else {
                ans+=maxRight-height[j];
                j--;
            }
        }
        return ans;
    }
}
