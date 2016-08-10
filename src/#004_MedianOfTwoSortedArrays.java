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

//solution #2:Binary Search
public class Solution2 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length,n=nums2.length;
        if(m>n){
            int t=m;m=n;n=t;
            int[] temp=nums1;nums1=nums2;nums2=temp;
        }
        int i,j,half=(m+n+1)/2;
        int imin=0,imax=m;
        int leftMax=0,rightMin=0;
        while(imin<=imax){
            i=(imin+imax)/2;
            j=half-i;
            if(j>0 && i<m && nums2[j-1]>nums1[i]) imin=i+1;
            else if(i>0 && j<n && nums1[i-1]>nums2[j]) imax=i-1;
            else{
                if(i==0) leftMax=nums2[j-1];
                else if(j==0) leftMax=nums1[i-1];
                else leftMax=Math.max(nums1[i-1,nums2[j-1]]);
                
                if((m+n)%2==1) return leftMax;
                
                if(i==m) rightMin=nums2[j];
                else if(j==n) rightMin=nums1[i];
                else rightMin=Math.min(nums1[i],nums2[j]);
                
                return (leftMax+rightMin)/2.0;
            }
        }
        return 0;
    }
}
