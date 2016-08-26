//solution #1
public class Solution1 {
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

//solution #2
public class Solution2 {
    public int longestValidParentheses(String s) {
        int ans=0;
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)=='(') {
                st.push(i);
            }else {
                if(!st.isEmpty() && s.charAt(st.peek())) {
                    st.pop();
                }else {
                    st.push(i);
                }
            }
        }
        int start=0,end=s.length();
        if(st.isEmpty()) return s.length();
        while(!st.isEmpty()) {
            start=st.pop();
            ans=Math.max(ans,end-start-1);
            end=start;
        }
        ans=Math.max(ans,start);
        return ans;
    }
}
