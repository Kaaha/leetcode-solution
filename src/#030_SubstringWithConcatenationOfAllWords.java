//solution #1:time limit exceed
public class Solution1 {
    public List<Integer> findSubstring(String s,String[] words) {
        List<Integer> ans=new ArrayList<>();
        int wordNum=words.length;
        int len=words[0].length();
        Map<String,Integer> map=new HashMap<>();
        for(String w:words) {
            map.put(w,map.containsKey(w)?map.get(w)+1:1);
        }
        for(int i=0;i+len*wordNum<s.length();i++) {
            Map<String,Integer> visit=new HashMap<>();
            for(int j=0;j<wordNum;j++) {
                String word=s.substring(j,j+len);
                if(!map.containsKey(word)) break;
                visit.put(word,visit.containsKey(word)?visit.get(word)+1:1);
            }
            if(visit.equals(map)) 
                ans.add(i);
        }
        return ans;
    }
}
