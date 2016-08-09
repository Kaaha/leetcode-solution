public class Solution {
    public int maxArea(int[] nums){
        int area=0;
        int n=nums.length;
        int i=0,j=n-1;
        while(i<j){
            int left=nums[i];
            int right=nums[j];
            area=Math.max(area,Math.min(left,right)*(j-i));
            if(left<right) i++;
            else j--;
        }
        return area;
    }
}
