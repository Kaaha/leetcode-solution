//solution #1:with O(1) space
public class Solution1 {
    public int firstMissingPositive(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++) {
            while(nums[i]>0 && nums[i]<=n && nums[nums[i]-1]!=nums[i]) swap(nums,i,nums[i]-1);
        }
        for(int i=0;i<n;i++) {
            if(nums[i]!=i+1) return i+1;
        }
        return n+1;
    }
    private void swap(int[] nums,int i,int j) {
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }
}

//solution #2:with O(n) space
public class Solution2 {
    int firstMissingPositive(int[] nums) {
        int n=nums.length;
        BitSet bit=new BitSet();
        for(int i=0;i<n;i++) {
            if(nums[i]>0) bit.set(nums[i]);
        }
        return bit.nextClearBit(1);
    }
}
