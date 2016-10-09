public class Solution {
    public int public int minPathSum(int[][] grid) {
        int m=grid[0].length;
        int[] table=new int[m];
        table[0]=grid[0][0];
        for(int i=1;i<m;i++) table[i]=table[i-1]+grid[0][i];
        for(int i=1;i<grid.length;i++) {
            for(int j=0;j<m;j++) {
                if(j>0) table[j]=Math.min(table[j],table[j-1])+grid[i][j];
                else table[j]+=grid[i][j];
            }
        }
        return table[m-1];
    }
}
