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

//solution #3
public class Solution3 {
    public int longestValidParentheses(String s) {
        int ans=0;
        int[] table=new table[s.length()];
        for(int i=1;i<s.length();i++) {
            if(s.charAt(i)==')') {
                int t=i-table[i-1]-1;
                if(t>=0 && s.charAt(t-1)=='(') {
                    int before=(t>0)?table[t-1]:0;
                    table[i]=before+2+table[i-1];
                    ans=Math.max(ans,table[i]);
                }
            }
        }
        return ans;
    }
}
