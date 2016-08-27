//solution #1
public class Solution1 {
    public int searchInsert(int[] nums,int target) {
        int n=nums.length;
        int lo=0,hi=n;
        while(lo<hi) {
            int mid=(lo+hi)/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid]<target) lo=mid+1;
            else hi=mid;
        }
        return lo;
    }
}
