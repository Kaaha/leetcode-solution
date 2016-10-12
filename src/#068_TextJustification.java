public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int n=words.length;
        List<String> ans=new ArrayList<>();
        int length=words[0].length(),num=1;
        if(n==1) {
            int allSpaces=maxWidth-length;
            StringBuilder sb=new StringBuilder();
            sb.append(words[0]);
            while(allSpaces-- > 0) sb.append(" ");
            ans.add(new String(sb));
        }
        for(int i=1;i<n;i++) {
            if(length+words[i].length()+num<=maxWidth) {
                length+=words[i].length();
                num++;
            }else {
                StringBuilder sb=new StringBuilder();
                int allSpace=maxWidth-length,m=(num>1)?num-1:1;
                for(int j=0;j<num;j++) {
                    int spaces=m==0?0:(int)Math.ceil((double)allSpace/m);
                    sb.append(words[i-num+j]);
                    allSpace-=spaces;
                    while(spaces-- > 0) sb.append(" ");
                    m--;
                }
                ans.add(new String(sb));
                length=words[i].length();
                num=1;
            }
            if(i==n-1) {
                StringBuilder sb=new StringBuilder();
                int spaces=num==1?0:1;
                for(int j=0;j<num;j++) {
                    int temp=spaces;
                    sb.append(words[i-num+j+1]);
                    while(temp-- > 0) sb.append(" ");
                }
                int allSpace=maxWidth-sb.length();
                while(allSpace-- > 0) sb.append(" ");
                ans.add(new String(sb));
            }
        }
        return ans;
    }
}
