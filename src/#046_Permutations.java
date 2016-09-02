public class Solution {
    private List<List<Integer>> ans;
    public List<List<Integer>> permute(int[] nums) {
        ans=new ArrayList<>();
        permute(nums,0);
        return ans;
    }
    private void premute(int[] nums,int i) {
        int n=nums.length;
        if(i==n) {
            List<Integer> list=new ArrayList<>();
            for(int a:nums) list.add(new Integer(a));
            ans.add(list);
        }
        for(int j=i;j<n;j++) {
            swap(nums,i,j);
            permute(nums,i+1);
            swap(nums,i,j);
        }
    }
    private void swap(int[] nums,int i,int j) {
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }
}
