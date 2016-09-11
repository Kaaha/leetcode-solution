//solution #1
public class  Solution1 {
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

//solution #2
public class Solution2 {
    public List<List<String>> groupAnagrams(String[] strs) {
        int[] primes={2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};
        Map<Integer,Integer> map=new HashMap<>();
        List<List<String>> ans=new ArrayList<>();
        for(String s:strs) {
            int key=1;
            for(char c:s.toCharArray()) key*=primes[c-'a'];
            List<String> list;
            if(map.containsKey(key)) {
                list=ans.get(map.get(key));
            }else {
                list=new ArrayList<String>();
                ans.add(list);
                map.put(key,ans.size()-1);
            }
            list.add(s);
        }
        return ans;
    }
}
