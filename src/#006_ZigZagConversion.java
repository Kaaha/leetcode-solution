public class Solution {
    public String convert(String s,int numRows) {
        int n=s.length();
        StringBuffer[] sb=new StringBuffer[numRows];
        int i=0;
        while(i<n) {
            for(int d=0;d<numRows && i<n;d++) {
                sb[d].append(s.charAt(i));
            }
            
            for(int u=numRows-1;u>=0 && i<n;u--) {
                sb[u].append(s.charAt(i));
            }
        }
        
        for(int i=1;i<numRows;i++) {
            sb[0].append(sb[i]);
        }
        return sb[0].toString();
    }
}
