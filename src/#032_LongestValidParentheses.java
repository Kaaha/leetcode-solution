public class Solution {
    public int longestValidParentheses(String s) {
        int ans=0;
        Stack<Integer> st=new Stack<>();
        int start=-1;
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)=='(') {
                st.push(i);
            }else {
                if(st.isEmpty()) {
                    start=i;
                }else {
                    st.pop();
                    if(st.isEmpty()) {
                        ans=Math.max(ans,i-start);
                    }else {
                        ans=Math.max(ans,i-st.peek());
                    }
                }
            }
        }
        return ans;
    }
}
