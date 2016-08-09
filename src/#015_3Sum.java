public class Solution {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> ans=new ArrayList<>();
		int n=nums.length;
		if(n<3) return ans;
		int i=0;
		Arrays.sort(nums);
		while(i<n-2){
			int j=i+1,k=n-1;
			while(j<k){
				int sum=nums[i]+nums[j]+nums[k];
				if(sum==0) ans.add(Arrays.asList(nums[i],nums[j],nums[k]));
				if(sum<=0) while(nums[j]==nums[++j] && j<k);
				if(sum>=0) while(nums[k--]==nums[k] && k>j);
			}
			while(nums[i]==nums[++i] && i<n-2);
		}
		return ans;
	}
}