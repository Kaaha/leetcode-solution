//solution #1
public class Solution1 {
    public String longestPalindrome(String s) {
        int n=s.length();
        boolean[][] table=new boolean[1000][1000];
        for(int i=0;i<n;i++) table[i][i]=true;
        int maxLen=1;
        int begin=0;
        for(int i=0;i<n-1;i++){
            if(s.charAt(i)==s.charAt(i+1)){
                table[i][i+1]=true;
                maxLen=2;
                begin=i;
            }
        }
        
        for(int len=3;len<=n;len++){
            for(int i=0;i<=n-len+1;i++){
                int j=len+i-1;
                if(table[i+1][j-1] && s.charAt(i)==s.charAt(j)){
                    table[i][j]=true;
                    begin=i;
                    maxLen=len;
                }
            }
        }
        return s.substring(begin,begin+maxLen);
    }
}

//solution #2
public class Solution2{
    public String longestPalindrome(String s) {
        int n=s.length();
        if(n==0) return "";
        String ans="";
        for(int i=0;i<s.length()-1;i++) {
            String s1=expandAroundCenter(s,i,i);
            String s2=expandAroundCenter(s,i,i+1);
            if(ans.length()<s1.length()) ans=s1;
            if(ans.length()<s2.length()) ans=s2;
        }
        return ans;
    }
    private String expandAroundCenter(String s,int left,int right) {
        int i=left,j=right;
        while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
            i--;j++;
        }
        return s.substring(i+1,j);
    }
}
