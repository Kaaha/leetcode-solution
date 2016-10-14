public class Solution {
    public boolean searchMatrix(int[][] matrix,int target) {
        int m=matrix.length;
        if(m==0) return false;
        int n=matrix[0].length;
        int lo=0,hi=m*n-1;
        while(lo<=hi) {
            int mid=(lo+hi)/2;
            int i=mid/n,j=mid%n;
            if(matrix[i][j]==target) return true;
            else if(matrix[i][j]<target) lo=mid+1;
            else hi=mid-1;
        }
        return false;
    }
}
