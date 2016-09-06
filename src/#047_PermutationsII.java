public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        if(nums==null || nums.length==0) return ans;
        List<Integer> list=new ArrayList<>();
        boolean[] used=new boolean[nums.length];
        Arrays.sort(nums);
        permute(nums,list,ans,usesd);
        return ans;
    }
    private void permute(int[] nums,List<Integer> list,List<List<Integer>> ans,boolean[] used) {
        if(list.size()==nums.length) {
            ans.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i=0;i<nums.length;i++) {
            if(used[i]) continue;
            if(i>0 && nums[i-1]==nums[i] && !used[i-1]) continue;
            list.add(nums[i]);
            used[i]=true;
            permute(nums,list,ans,used);
            used[i]=false;
            list.remove(list.size()-1);
        }
    }
}
