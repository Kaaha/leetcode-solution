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

//solution #2
public class Solution2 {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        int temp;
        for(int i=0;i<n/2;i++) {
            for(int j=i;j<n-i-1;j++) {
                temp=matrix[i][j];
                matrix[i][j]=matrix[n-j-1][i];
                matrix[n-j-1][i]=matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1]=matrix[j][n-i-1];
                matrix[j][n-i-1]=temp;
            }
        }
    }
}
