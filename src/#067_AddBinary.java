public class Solution {
    public String addBinary(String a, String b) {
        String s1,s2;
        if(a.length()<b.length()) {
            s1=a;s2=b;
        }else {
            s1=b;s2=a;
        }
        int carry=0;
        StringBuilder sb=new StringBuilder();
        int i=0,n=s1.length(),m=s2.length();
        while(i<s1.length()) {
            int sum=carry+(s1.charAt(n-i-1)-'0')+(s2.charAt(m-1-i)-'0');
            carry=sum/2;
            sb.insert(0,sum%2);
            i++;
        }
        while(i<m) {
            int sum=carry+(s2.charAt(m-1-i)-'0');
            carry=sum/2;
            sb.insert(0,sum%2);
            i++;
        }
        if(carry==1) sb.insert(0,1);
        return sb.toString();
    }
}
