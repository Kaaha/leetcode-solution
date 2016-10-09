//solution #1
public class Solution1 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        if(obstacleGrid[0][0]==1) return 0;
        int idx=0;
        while(idx<m && obstacleGrid[idx][0]==0) obstacleGrid[idx++][0]=-1;
        while(idx<m) obstacleGrid[idx][0]=0;
        idx=1;
        while(idx<n && obstacleGrid[0][idx]==0) obstacleGrid[0][idx++]=-1;
        while(idx<n) obstacleGrid[idx++][0]=0;
        for(int i=1;i<m;i++) {
            for(int j=1;j<n;j++) {
                if(obstacleGrid[i][j]==1) obstacleGrid[i][j]=0;
                else obstacleGrid[i][j]=obstacleGrid[i-1][j]+obstacleGrid[i][j-1];
            }
        }
        return -obstacleGrid[m-1][n-1];
    }
}

//solution #2
public class Solution2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int width=obstacleGrid[0].width;
        int[] table=new int[width];
        table[0]=1;
        for(int[] row : obstacleGrid) {
            for(int i=0;i<width;i++) {
                if(obstacleGrid[i]==1) table[i]=0;
                else if(i>0) table[i]+=table[i-1];
            }
        }
        return table[width-1];
    }
}
