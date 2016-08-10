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
            map.put(c,++j);
        }
        return ans;
    }
}

//solution #2
public class Solution2 {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        Set<Character> set=new HashSet<>();
        int i=0,j=0;
        while(i<n && j<n){
            char c=s.charAt(j);
            if(set.contains(c)){
                set.remove(c);
                i++;
            }else{
                set.add(c);
                j++;
                ans=Math.max(ans,j-i);
            }
        }
        return ans;
    }
}

//solution #3
public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        if(n==0) return 0;
        int ans=1;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(isUnique(s,i,j)){
                    ans=Math.max(ans,j-i+1);
                }
            }
        }
        return ans;
    }
    private boolean isUnique(String s,int left,int right){
        Set<Character> set=new HashSet<>();
        for(int i=left;left<=right;left++){
            if(set.contains(s.charAt(left)))
                return false;
            set.add(s.charAt(left));
        }
        return true;
    }
}
