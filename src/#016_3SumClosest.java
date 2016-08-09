//solution #1:Brute Force
public class Solution {
    public int threeSumClosest(int[] nums,int target) {
        int n=nums.length;
        if(n<3) throw new IllegalArgumentException("No solution.");
        int ans=nums[0]+nums[1]+nums[2];
        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                for(int k=j+1;k<n;k++){
                    int sum=nums[i]+nums[j]+nums[k];
                    ans=Math.abs(ans-target)>Math.abs(sum-target)?sum:ans;
                }
            }
        }
        return ans;
    }
}
