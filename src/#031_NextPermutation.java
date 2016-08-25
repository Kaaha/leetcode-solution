public class Solution {
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int i=n-2;
        while(i>=0 && nums[i]>=nums[i+1]) i--;
        if(i>=0) {
            int j=i+1;
            while(j<n && nums[j]>nums[i]) j++;
            swap(nums,i,j-1);
        }
        reverse(nums,i,n-1);
    }
    private void reverse(int[] nums,int i) {
        int j=nums.length-1;
        while(i<j) swap(nums,i++,j--);
    }
    private void swap(int[] nums,int i,int j) {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
