//solution #1:Brute Force
public class Solution1 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length,n=nums2.length;
        int[] nums=new int[m+n];
        int i=0,j=0,k=0;
        while(i<m && j<n){
            if(nums1[i]<nums2[j]) nums[k++]=nums1[i++];
            else nums[k++]=nums2[j++];
        }
        while(i<n) nums[k++]=nums1[i++];
        while(j<m) nums[k++]=nums2[j++];
        return (nums[(m+n)/2]+nums[(m+n-1)/2])/2.0;
    }
}
