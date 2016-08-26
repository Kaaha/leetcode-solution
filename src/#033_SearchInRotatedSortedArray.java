public class Solution {
    int search(int[] nums,int target) {
        int n=nums.length;
        int i=0,j=n-1;
        while(i<j) {
            int mid=(i+j)/2;
            if(nums[mid]>nums[j]) i=mid+1;
            else j=mid;
        }
        int offset=mid;
        i=0;j=n-1;
        while(i<=j) {
            int mid=(i+j)/2;
            int k=(mid+offset)%n;
            if(nums[k]==target) return k;
            else if(target<nums[k]) j=mid-1;
            else i=mid+1;
        }
        return -1;
    }
}
