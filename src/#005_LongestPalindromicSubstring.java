//solution #2
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
