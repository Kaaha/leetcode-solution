//solution #1:backtracking
public class Solution1 {
    private static final String[] KEYS={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits){
        List<String> ans=new LinkedList<>();
        if(digits.length()==0) return ans;
        combinations("",digits,0,ans);
        return ans;
    }
    private void combinations(String prefix,String digits,int offset,List<String> ans){
        if(offset>=digits.length()){
            ans.add(prefix);
            return;
        }
        String letters=KEYS[digits.charAt(offset)-'0'];
        for(int i=0;i<letters.length();i++){
            char c=digits.charAt(i);
            combinations(prefix+c,digits,offset+1,ans);
        }
    }
}

//solution #2:FIFO list
public class Solution2 {
    private static final String[] KEYS={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits){
        LinkedList<String> ans=new LinkedList<>();
        int n=digits.length();
        if(n==0) return ans;
        ans.add("");
        for(int i=0;i<n;i++){
            while(ans.size()>0 && ans.peek().length()==i){
                String prefix=ans.remove();
                String letters=KEYS[digits.charAt(i)-'0'];
                for(int j=0;j<letters.length();j++){
                    char c=letters.charAt(j);
                    ans.add(prefix+c);
                }
            }
        }
        return ans;
    }
}
