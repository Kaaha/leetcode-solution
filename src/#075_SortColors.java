//solution #1
public class Solution1 {
    public void sortColors(int[] nums) {
        int red=0,white=0,blue=0;
        for(int a:nums) {
            if(a==0) red++;
            else if(a==1) white++;
            else blue++;
        }
        int i=0;
        while(i<red) nums[i++]=0;
        while(i<red+white) nums[i++]=1;
        while(i<red+white+blue) nums[i++]=2;
    }
}
