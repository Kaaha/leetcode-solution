//solution #1
public class Solution1 {
    public String multiply(String num1,String num2) {
        int m=num1.length();
        String ans="";
        for(int i=m-1;i>=0;i--) {
            int a=num1.charAt(i)-'0';
            String s=multiply(num2,a);
            s=s.equals("0")?"0":appendZeros(s,m-i-1);
            ans=addTwoNumbers(ans,s);
        }
        return ans;
    }
    private String appendZeros(String s,int n) {
        StringBuilder ans=new StringBuilder(s);
        int i=0;
        while(i++<n) ans.append(0);
        return ans.toString();
    }
    private String multiply(String s,int d) {
        if(d==0) return "0";
        if(d==1) return s;
        StringBuilder ans=new StringBuilder();
        int n=s.length();
        int i=n-1,carry=0;
        while(i>=0) {
            int a=s.charAt(i--)-'0';
            int digit=(a*d+carry)%10;
            carry=(a*d+carry)/10;
            ans.append(digit);
        }
        if(carry>0) ans.append(carry);
        return ans.reverse().toString();
    }
    private String addTwoNumbers(String s1,String s2) {
        StringBuilder ans=new StringBuilder();
        int m=s1.length(),n=s2.length();
        int i=m-1,j=n-1;
        int carry=0;
        while(i>=0 && j>=0) {
            int a=s1.charAt(i--)-'0';
            int b=s2.charAt(j--)-'0';
            int digit=(a+b+carry)%10;
            carry=(a+b+carry)/10;
            ans.append(digit);
        }
        while(i>=0) {
            int a=s1.charAt(i--)-'0';
            int digit=(a+carry)%10;
            carry=(a+carry)/10;
            ans.append(digit);
        }
        while(j>=0) {
            int b=s2.charAt(j--)-'0';
            int digit=(b+carry)%10;
            carry=(b+carry)/10;
            ans.append(digit);
        }
        if(carry>0) ans.append(carry);
        return ans.reverse().toString();
    }
}
