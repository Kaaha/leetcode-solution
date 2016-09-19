public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans=new int[n][n];
        int rowBegin=0,rowEnd=n-1;
        int colBegin=0,colEnd=n-1;
        int num=1;
        while(rowBegin<=rowEnd && colBegin<=colEnd) {
            //right
            for(int i=colBegin;i<=colEnd;i++) {
                ans[colBegin][i]=num++;
            }
            rowBegin++;
            //down
            for(int i=rowBegin;i<=rowEnd;i++) {
                ans[i][rowEnd]=num++;
            }
            colEnd--;
            //left
            for(int i=colEnd;i>=colBegin;i--) {
                if(rowBegin>rowEnd) break;
                ans[rowEnd][i]=num++;
            }
            //up
            for(int i=rowEnd;i>=rowBegin;i--) {
                if(colBegin>colEnd) break;
                ans[i][colBegin]=num++;
            }
        }
        return ans;
    }
}
