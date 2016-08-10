//solution #1
public class Solution1{
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        int ans=0;
        Map<Character,Integer> map=new HashMap<>();
        int i=0,j=0;
        while(i<n && j<n){
            char c=s.charAt(j);
            if(map.containsKey(c)){
                i=Math.max(i,map.get(c));
            }
            ans=Math.max(ans,j-i+1);
            map.put(c,j++);
        }
        return ans;
    }
}
