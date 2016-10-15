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

//solution #2
public class Solution2 {
    public void sortColors(int[] nums) {
        int zero=0,two=nums.length-1;
        for(int i=0;i<=two;i++) {
            while(nums[i]==2 && i<two) swap(nums,i,two--);
            while(nums[i]==0 && i>zero) swap(nums,i,zero++);
        }
    }
    private void swap(int[] nums,int i,int j) {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
