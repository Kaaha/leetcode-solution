//solution #1
public class Solution1 {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> set=new HashSet<>();
        int dot=0;
        //row
        for(int i=0;i<9;i++) {
            for(int j=0;j<9;j++) {
                if(board[i][j]=='.') dot++;
                else set.add(board[i][j]);
            }
            if(dot+set.size()!=9) return false;
            dot=0;set.clear();
        }
        //column
        for(int j=0;j<9;j++) {
            for(int i=0;i<9;i++) {
                if(board[i][j]=='.') dot++;
                else set.add(board[i][j]);
            }
            if(dot+set.size()!=size) return false;
            dot=0;set.clear();
        }
        //sub-box
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                for(int k=0;k<3;k++) {
                    for(int m=0;m<3;m++) {
                        if(board[3*i+k][3*j+m]=='.') dot++;
                        else set.add(board[3*i+k][3*j+m]);
                    }
                }
                if(dot+set.size()!=9) return false;
                dot=0;set.clear();
            }
        }
        return true;
    }
}

//solution #2
public class Solution2 {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row=new boolean[9][9];
        boolean[][] column=new boolean[9][9];
        boolean[][] subBox=new boolean[9][9];
        for(int i=0;i<9;i++) {
            for(int j=0;j<9;j++) {
                if(board[i][j]!='.') {
                    int digit=board[i][j]-'0'-1;
                    int k=i/3*3+j/3;
                    if(row[i][digit] || column[j][digit] || subBox[k][digit]) return false;
                    row[i][digit]=column[j][digit]=subBox[k][digit]=true;
                }
            }
        }
        return true;
    }
}
