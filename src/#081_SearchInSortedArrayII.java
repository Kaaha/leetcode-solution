public class Solution {
    public boolean search(int[] nums, int target) {
        int n=nums.length;
        int i=0,j=n-1;
        while(i<j) {
            int mid=(i+j)/2;
            if(nums[mid]>nums[j]) i=mid+1;
            else if(nums[mid]==nums[j]) {
                while(i<j && nums[j-1]==nums[mid]) j--;
                if(j>mid) i=mid+1;
            }
            else j=mid;
        }
        int offset=i;
        i=0;j=n-1;
        while(i<=j) {
            int mid=(i+j)/2;
            int k=(mid+offset)%n;
            if(nums[k]==target) return true;
            else if(target<nums[k]) j=mid-1;
            else i=mid+1;
        }
        return false;
    }
}
