public class Solution {
    public int jump(int[] nums) {
        int n=nums.length;
        int step=0;
        int max=0;
        int e=0;
        for(int i=0;i<n-1;i++) {
            max=Math.max(max,i+nums[i]);
            if(i==e) {
                step++;
                e=max;
            }
        }
        return step;
    }
}
