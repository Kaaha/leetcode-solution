public class  Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs==null ||strs.length==0) return new ArrayList<List<String>>();
        Map<String,List<String>> map=new HashMap<>();
        Arrays.sort(strs);
        for(String s:strs) {
            char[] cs=s.toCharArray();
            Arrays.sort(cs);
            String key=String.valueOf(cs);
            if(!map.containsKey(key)) map.put(key,new ArrayList<List<String>>());
            map.get(key).add(s);
        }
        return new ArrayList<List<String>>(map.values);
    }
}
