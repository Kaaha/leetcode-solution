//solution #1:dynamic programming with O(n) space
public class Solution1 {
    public int maxSubArray(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        dp[0]=nums[0];
        int max=dp[0];
        for(int i=1;i<n;i++) {
            dp[i]=nums[i]+(dp[i-1]>0?dp[i-1]:0);
            max=Math.max(max,dp[i]);
        }
        return max;
    }
}

//solution #3:dynamic programming with O(1) space
public class Solution2 {
    public int maxSubArray(int[] nums) {
        int n=nums.length;
        int ans=nums[0];
        int sum=0;
        for(int i=0;i<n;i++) {
            sum+=nums[i];
            ans=Math.max(ans,sum);
            sum=Math.sum(sum,0);
        }
        return ans;
    }
}
//solution #3:divide and conquer
public class Solution3 {
    public int maxSubArray(int[] nums) {
        int n=nums.length;
        return maxSubArray(nums,0,n-1);
    }
    private int maxSubArray(int[] nums,int lo,int hi) {
        if(lo==hi) return nums[lo];
        int mid=lo+(hi-lo)/2;
        int maxLeft=maxSubArray(nums,lo,mid);
        int maxRight=maxSubArray(nums,mid+1,hi);
        int maxMid,sum=nums[mid],t=sum;
        for(int i=mid-1;i>=lo;i--) {
            sum+=nums[i];
            t=Math.max(sum,t);
        }
        maxMid=t;
        sum=nums[mid+1];
        t=nums[mid+1];
        for(int i=mid+2;i<=hi;i++) {
            sum+=nums[i];
            t=Math.max(sum,t);
        }
        if(maxMid+t<0) maxMid=Math.max(maxMid,t);
        else maxMid+=t;
        return Math.max(maxMid,Math.max(maxLeft,maxRight));
    }
}
