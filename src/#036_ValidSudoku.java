public class boolean isValidSudoku(char[][] board) {
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
