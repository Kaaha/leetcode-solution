public class Solution {
    public int minDistance(String word1,String word2) {
        int m=word1.length(),n=word2.length();
        int[][] table=new int[m][n];
        for(int i=0;i<=m;i++) table[i][0]=i;
        for(int j=0;j<=n;j++) table[0][j]=j;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(word1.charAt(i)==word2.charAt(j)) table[i+1][j+1]=table[i][j];
                else {
                    int tmp=Math.min(table[i+1][j],table[i][j+1]);
                    table[i+1][j+1]=Math.min(tmp,table[i][j]);
                    table[i+1][j+1]++;
                }
            }
        }
        return table[m][n];
    }
}
