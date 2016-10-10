public class Solution {
    public int[] plusOne(int[] digits) {
        int n=digits.length;
        int carry=1;
        for(int i=n-1;i>=0;i--) {
            int sum=carry+digits[i];
            carry=sum/10;
            digits[i]=sum%10;
        }
        if(carry==0) return digits;
        else {
            int[] ans=new int[n+1];
            ans[0]=1;
            return ans;
        }
    }
}
