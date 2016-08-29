public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates,int target) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(candidates);
        combination(ans,new ArrayList<Integer>(),candidates,target,0);
        return ans;
    }
    private void combination(List<List<Integer>> ans,List<Integer> list,int[] candidates,int target,int begin) {
        if(target==0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=begin;i<candidates.length && target>=candidates[i];i++) {
            list.add(candidates[i]);
            combination(ans,list,candidates,target-candidates[i],i++);
            while(i<candidates.length-1 && candidates[i]==candidates[i+1]) i++;
            list.remove(list.size()-1);
        }
    }
}
