public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new LinkedList<>();
        int n=nums.length,total=(int)Math.pow(2,n);
        for(int i=0;i<total;i++) ans.add(new ArrayList<Integer>());
        for(int i=0;i<n;i++) {
            for(int j=0;j<total;j++) {
                if(((j>>i)&1)==1) lists.get(j).add(nums[i]);
            }
        }
        return ans;
    }
}
