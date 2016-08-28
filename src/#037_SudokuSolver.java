public class Solution {
    
    private boolean flag;
    
    private boolean[][] row=new boolean[9][9];
    private boolean[][] column=new boolean[9][9];
    private boolean[][] subBox=new boolean[9][9];
    
    public void sudokuSolver(char[][] board) {
        for(int i=0;i<9;i++) {
            for(int j=0;j<9;j++) {
                if(board[i][j]=='.') {
                    int digit=board[i][j]-'0'-1;
                    int k=i/3*3+j/3;
                    row[i][digit]=column[j][digit]=subBox[k][digit]=true;
                }
            }
        }
        solver(board,0,0);
    }
    
    private void solver(char[][] board,int i,int j) {
        if(flag) return;
        if(i>=9) {
            flag=true;
            return;
        }
        
        if(board[i][j]!='.') {
            if(j<8) solver(board,i,j+1);
            else solver(board,i+1,0);
            if(flag) return;
        }else {
            int k=i/3*3+j/3;
            for(int n=1;n<=9;n++) {
                if(!row[i][n-1] && !column[j][n-1] && subBox[k][n-1]) {
                    board[i][j]=(char)(n+'0');
                    row[i][n-1]=column[j][n-1]=subBox[k][n-1]=true;
                    if(j<8) solver(board,i,j+1);
                    else solver(board,i+1,0);
                    row[i][n-1]=column[j][n-1]=subBox[k][n-1]=false;
                    if(flag) return;
                }
            }
            board[i][j]='.';
        }
    }
}
