public class Solution {
    public boolean isValid(String s){
        Stack<Character> st=new Stack<>();
        for(char c:s.toCharArray()){
            switch(c){
                case '(':
                case '{':
                case '[':st.push(c);break;
                case ')':{
                    if(st.empty()) return false;
                    char t=st.peek();
                    if(t!='(') return false;
                    st.pop();
                    break;
                }
                case '}':{
                    if(st.empty()) return false;
                    char t=st.peek();
                    if(t!='{') return false;
                    st.pop();
                    break;
                }
                case ']':{
                    if(st.empty()) return false;
                    char t=st.pop();
                    if(t!='[') return false;
                    st.pop();
                    break;
                }
                default:break;
            }
            return st.empty();
        }
    }
}
