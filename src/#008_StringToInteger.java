public class Solution {
    public int myAtoi(String str) {
        String s=str.trim();
        int n=s.length();
        if(n==0) return 0;
        int ans=0;
        int sign=1;
        for(int i=0;i<n;i++) {
            //check the sign
            if(s.charAt(i)=='-') {
                sign=-1;
                i++;
            }
            else if(s.charAt(i)=='+') i++;
            if(i==n) return 0;
            if(!Character.isDigit(s.chatAt(i))) break;
            int digit=s.charAt(i)-'0';
            if(Integer.MAX_VLAUE/10 < ans || Integer.MAX_VALUE/10==ans && Integer.MAX_VALUE % 10 <digit)
                return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
            ans=ans*10+digit;
        }
        ans*=sign;
        return ans;
    }
}
