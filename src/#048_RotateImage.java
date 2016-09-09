//solution #1
public class Solution1 {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        int[][] temp=new int[n][n];
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                temp[i][j]=matrix[n-j-1][i];
            }
        }
        
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                matrix[i][j]=temp[i][j];
            }
        }
    }
}
