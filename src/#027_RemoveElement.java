//solution #1
public class Solution1 {
    public int removeElement(int[] nums,int val) {
        int n=0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]!=val)
                nums[n++]=nums[i];
        }
        return n;
    }
}

//solution #2
public class Solution2 {
    public int removeElement(int[] nums,int val) {
        int i=0,j=nums.length-1;
        while(i<=j) {
            while(i<=j && nums[i]!=val) i++;
            while(i<=j && nums[j]==val) j--;
            if(i<=j) {
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                i++;j--;
            }
        }
        return i;
    }
}

//solution #3
public class Solution3 {
    public int removeElement(int[] nums,int val) {
        int i=0,n=nums.length;
        while(i<n) {
            if(nums[i]==val) {
                nums[i]=nums[n-1];
                n--;
            }else {
                i++;
            }
        }
        return i;
    }
}
