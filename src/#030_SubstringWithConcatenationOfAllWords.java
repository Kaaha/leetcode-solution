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

//solution #2:accepted
public class Solution2 {
    public List<Integer> findSubstring(String s,String[] words) {
        List<Integer> ans=new ArrayList<>();
        int wordNum=words.length;
        int len=words[0].length();
        Map<String,Integer> map=new HashMap<>();
        for(String w:words) {
            map.put(w,map.containsKey(w)?map.get(w)+1:1);
        }
        int i,base=0;
        while(base<len) {
            Map<String,Integer> visit=new HashMap<>();
            int count=wordNum;
            i=base;
            while(i+len<s.length()) {
                String curr=s.substring(i,i+len);
                if(!map.containsKey(curr)) {
                    visit.clear();
                    count=wordNum;
                }else if(visit.containsKey(curr) && visit.get(curr)==map.get(curr)) {
                    for(int j=i+(count-wordNum)*len;!s.substring(j,j+len).equals(curr);j+=len) {
                        String ss=s.substring(j,j+len);
                        visit.put(ss,visit.containsKey(ss)?visit.get(ss)+1:1);
                        count++;
                    }
                }else {
                    visit.put(curr,visit.containsKey(curr)?visit.get(curr)+1:1);
                    count--;
                    if(count==0) {
                        String first=s.substring(i-(wordNum-1)*len,i-(wordNum-2)*len);
                        visit.put(first,visit.get(first)-1);
                        ans.add(i-(wordNum-1)*len);
                        count=1;
                    }
                }
                i+=len;
            }
            base++;
        }
        return ans;
    }
}
