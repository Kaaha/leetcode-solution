//solution #1
public class Solution1 {
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<List<Integer>> ans=new LinkedList<List<Integer>>();
        ans.add(new ArrayList<Integer>());
        for(int n:nums) {
            int len=ans.size();
            for(;len>0;len--) {
                List<Integer> list=ans.pollFirst();
                for(int i=0;i<=list.size();i++) {
                    List<Integer> t=new ArrayList<>(list);
                    t.add(i,n);
                    ans.add(t);
                }
            }
        }
        return ans;
    }
}

//solution #2
public class Solution2 {
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
