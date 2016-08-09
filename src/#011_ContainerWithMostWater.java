public class Solution {
    public int maxArea(int[] height){
        int area=0;
        int n=height.length;
        int i=0,j=n-1;
        while(i<j){
            int left=height[i];
            int right=height[j];
            area=Math.max(area,Math.min(left,right)*(j-i));
            if(left<right) i++;
            else j--;
        }
        return area;
    }
}
