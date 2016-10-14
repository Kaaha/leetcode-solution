//solution #1
public class Solution1 {
    public void setMatrixZeroes(int[][] matrix) {
        int m=matrix.length,n=matrix[0].length;
        int[] row=new int[m];
        int[] col=new int[n];
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(matrix[i][j]==0) {
                    row[i]=1;
                    col[j]=1;
                }
            }
        }
        for(int i=0;i<m;i++) {
            if(row[i]==1) for(int j=0;j<n;j++) matrix[i][j]=0;
        }
        for(int j=0;j<n;j++) {
            if(col[j]==1) for(int i=0;i<m;i++) matrix[i][j]=0;
        }
    }
}

//solution #2
public class Solution2 {
    public void setMatrixZeroes(int[][] matrix) {
        int m=matrix.length,n=matrix[0].length;
        boolean left=false,up=false;
        for(int i=0;i<m;i++) if(matrix[i][0]==0) {
            left=true;
            break;
        }
        for(int j=0;j<n;j++) if(matrix[0][j]==0) {
            up=true;
            break;
        }
        
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(matrix[i][j]==0) {
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        
        for(int i=1;i<m;i++) {
            if(matrix[i][0]==0) for(int j=1;j<n;j++) matrix[i][j]=0;
        }
        for(int j=1;j<n;j++) {
            if(matrix[0][j]==0) for(int i=1;i<m;i++) matrix[i][j]=0;
        }
        
        if(left) for(int i=0;i<m;i++) matrix[i][0]=0;
        if(up) for(int j=0;j<n;j++) matrix[0][j]=0;
    }
}
