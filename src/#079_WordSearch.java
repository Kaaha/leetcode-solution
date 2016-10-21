public class Solution {
    public boolean exist(char[][] board, String word) {
        int m=board.length,n=board[0].length;
        char[] chars=word.toCharArray();
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) 
                if(exist(board,chars,i,j,0)) return true;
        }
        return false;
    }
    private boolean exist(char[][] board,char[] chars,int idxi,int idxj,int n) {
        if(n==chars.length) return true;
        if(idxi>=board.length || idxi<0 || idxj>=board[0].length || idxj<0) return false;
        if(board[idxi][idxj]!=chars[n]) return false;
        boolean ans=false;
        if(idxi>0) {
            board[idxi][idxj]^=256;
            ans=exist(board,chars,idxi-1,idxj,n+1);
            if(ans) return ans;
            board[idxi][idxj]^=256;
        }
        if(idxi<board.length) {
            board[idxi][idxj]^=256;
            ans=exist(board,chars,idxi+1,idxj,n+1);
            if(ans) return ans;
            board[idxi][idxj]^=256;
        }
        if(idxj>0) {
            board[idxi][idxj]^=256;
            ans=exist(board,chars,idxi,idxj-1,n+1);
            if(ans) return ans;
            board[idxi][idxj]^=256;
        }
        if(idxj<board[0].length) {
            board[idxi][idxj]^=256;
            ans=exist(board,chars,idxi,idxj+1,n+1);
            if(ans) return ans;
            board[idxi][idxj]^=256;
        }
        return ans;
    }
}
