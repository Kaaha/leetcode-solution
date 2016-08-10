public class Solution {
    public List<List<Integer>> fourSum(int[] nums,int target) {
        int n=nums.length;
        List<List<Integer>> ans=new ArrayList<>();
        if(n<4) return ans;
        int i=0,j;
        Arrays.sort(nums);
        int max=nums[n-1];
        while(i<n-3) {
            while((nums[i]+3*max)<target && i<n-3) i++;
            j=i+1;
            while(j<n-2) {
                while((nums[i]+nums[j]+2*max)<target && j<n-2) j++;
                int l=j+1,r=n-1;
                while((nums[i]+nums[j]+nums[l]+max)<target && l<r) l++;
                while(l<r) {
                    int sum=nums[i]+nums[j]+nums[l]+nums[r];
                    if(sum==target) ans.add(Arrays.asList(nums[i],nums[j],nums[l],nums[r]));
                    if(sum<=target) while(nums[l]==nums[++l] && l<r);
                    if(sum>=target) while(nums[r]==nums[--r] && l<r);
                }
                while(nums[j]==nums[++j] && j<n-2);
            }
            while(nums[i]==nums[++i] && i<n-3);
        }
        return ans;
    }
}
