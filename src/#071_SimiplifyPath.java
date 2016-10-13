public class Solution {
    public String simiplifyPath(String path) {
        String[] ss=path.split("/");
        List<String> st=new ArrayList<>();
        for(String s:ss) {
            if(s.equals("")) continue;
            else if(s.equals(".")) continue;
            else if(s.equals("\")) {
                if(st.size()>0) st.remove(st.size()-1);                 
            }
            else st.add(s);
        }
        String ans="/"+String.join("/",st.toArray(new String[0]));
        return ans;
    }
}
