public class Solution {
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
