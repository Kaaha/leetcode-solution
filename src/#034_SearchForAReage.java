//solution #1
public class Solution1 {
    public int[] searchRange(int[] nums,int target) {
        int[] ans=new int[]{-1,-1};
        int n=nums.length;
        int lo=0,hi=n-1;
        while(lo<=hi) {
            int mid=(lo+hi)/2;
            if(nums[mid]==target) {
                ans[0]=mid;
                ans[1]=mid;
                break;
            }else if(nums[mid]<target) lo=mid+1;
            else hi=mid-1;
        }
        if(ans[0]==-1) return ans;
        int i=ans[0],j=ans[1];
        while(i>=0 && nums[i]==target) i--;
        while(j<n && nums[j]==target) j++;
        ans[0]=i+1;
        ans[j]=j-1;
        return ans;
    }
}

//solution #2
public class Solution2 {
    int[] ans=new int[]{-1,-1};
    int n=nums.length;
    int lo=0,hi=n-1;
    //find the left boundary
    while(lo<hi) {
        int mid=(lo+hi)/2;
        if(nums[mid]<target) lo=mid+1;//the left boundary is on the right side
        else hi=mid;//the left boundary is on the left side
    }
    if(nums[lo]!=target) return ans;
    ans[0]=lo;
    hi=n-1;
    //find the right boundary
    while(lo<hi) {
        int mid=(lo+hi)/2+1;//make the mid biased to hi
        if(nums[mid]>target) hi=mid-1;//the right boundary is on the left side
        else lo=mid;//the right boundary is on the right side
    }
    ans[1]=hi;
    return ans;
}
