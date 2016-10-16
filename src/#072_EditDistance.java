//solution #1
public class Solution1 {
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

//solution #2
public class Solution2 {
    public int minDistance(String word1,String word2) {
        int m=word1.length(),n=word2.length();
        if(m==0) return n;
        if(n==0) return m;
        int[][] table=new int[m][n];
        
    }
    private int getMinDistance(String word1,String word2,int i,int j,int[][] table) {
        if(i<0 && j<0) return 0;
        if(i<0) return j+1;
        if(j<0) return i+1;
        if(table[i][j]!=0) return table[i][j];
        if(word1.charAt(i)==word2.charAt(j)) {
            table[i][j]=getMinDistance(word1,word2,i-1,j-1,table);
            return table[i][j];
        }
        int insert=getMinDistance(word1,word2,i-1,j,table)+1;
        int delete=getMinDistance(word1,word2,i,j-1,table)+1;
        int alter=getMinDistance(word1,word2,i-1,j-1,table)+1;
        int tmp=Math.min(insert,delete);
        table[i][j]=Math.min(tmp,alter);
        return table[i][j];
    }
}
