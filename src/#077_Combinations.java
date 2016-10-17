public class Solution1 {
    public List<List<Integer>> combine(int n,int k) {
        List<List<Integer>> ans=new LinkedList<>();
        if(n<k || n==0) return ans;
        List<Integer> list=new LinkedList<>();
        genList(ans,list,n,1,k);
        return ans;
    }
    private void genList(List<List<Integer>> ans,List<Integer> list,int n,int idx,int k) {
        if(k==list.size()) {
            List<Integer> tmp=new LinkedList<>(list);
            ans.add(tmp);
            return;
        }
        for(int i=idx;i<=n;i++) {
            list.add(i);
            genList(ans,list,n,i+1,k);
            list.remove(list.size()-1);
        }
    }
}
