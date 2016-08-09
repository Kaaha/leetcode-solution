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

//solution #2:two pointers
public class Solution2 {
    public int threeSumClosest(int[] nums,int target) {
        int n=nums.length;
        if(n<3) throw new IllegalArgumentException("No solution.");
        int ans=nums[0]+nums[1]+nums[2];
        int i=0;
        Arrays.sort(nums);
        while(i<n-2){
            int j=i+1,k=n-1;
            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
                ans=Math.abs(ans-target)>Math.abs(sum-target)?sum:ans;
                if(ans==target) return sum;
                if(sum<target) j++;
                else k--;
            }
            while(nums[i]==nums[++i] && i<n-2);
        }
        return ans;
    }
}
