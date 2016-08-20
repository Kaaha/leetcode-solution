public class Solution {
    public List<String> genereateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        if(n<=0) return ans;
        generateParenthesis("",n,n,ans);
        return ans;
    }
    private void generateParenthesis(String s,int l,int r,List<String> ans) {
        if(r==0) {
            ans.add(s);
            return;
        }
        if(l>0) {
            generateParenthesis(s+'(',l-1,r,ans);
        }
        if(l<r) {
            generateParenthesis(s+')',l,r-1,ans);
        }
    }
}
