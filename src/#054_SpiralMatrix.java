public class Solution {
    public List<Integer> spiralMatrix(int[][] matrix) {
        List<Integer> ans=new ArrayList<>();
        int m=matrix.length;
        if(m==0) return ans;
        int n=matrix[0].length;
        if(n==0) return ans;
        int rowBegin=0,rowEnd=m-1;
        int colBegin=0,colEnd=n-1;
        while(rowBegin<=rowEnd && colBegin<=colEnd) {
            //right
            for(int i=colBegin;i<=colEnd;i++) {
                ans.add(matrix[rowBegin][i]);
            }
            rowBegin--;
            //down
            for(int i=rowBegin;i<=rowEnd;i++) {
                ans.add(matrix[i][colEnd]);
            }
            colEnd--;
            //left
            for(int i=colEnd;i>=colBegin;i--) {
                if(colEnd<colBegin) break;
                ans.add(matrix[rowEnd][i]);
            }
            colEnd--;
            //up
            for(int i=rowEnd;i>=rowBegin;i--) {
                if(rowEnd<rowBegin) break;
                ans.add(matrix[i][colBegin]);
            }
            colBegin++;
        }
        return ans;
    }
}
