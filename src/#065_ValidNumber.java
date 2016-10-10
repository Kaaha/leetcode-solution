public class Solution {
    public boolean isNumber(String s) {
        s=s.trim();
        if(s.length()==0) return false;
        int state=0;
        for(char c:s.toCharArray()){
            if(state==0 && (c=='+' || c=='-')) {
                state=1;
                continue;
            }else if((state==0 || state==1 || state==2)&& Character.isDigit(c)) {
                state=2;
                continue;
            }else if((state==2 || state==3) && c=='e') {
                state=5;
                continue;
            }else if((state==0 || state==1) && c=='.') {
                state=4;
                continue;
            }else if((state==4 || state==3) && Character.isDigit(c)) {
                state=3;
                continue;
            }else if(state==2 && c=='.') {
                state=3;
                continue;
            }else if(state==5 && (c=='+' || c=='-')) {
                state=6;
                continue;
            }else if((state==5 || state==6 || state==7) && Character.isDigit(c)) {
                state=7;
                continue;
            }else if(state==5 && Character.isDigit(c)) {
                state=7;
                continue;
            }else return false;
        }
        return state!=4 && state!=6 && state!=5;
    }
}
