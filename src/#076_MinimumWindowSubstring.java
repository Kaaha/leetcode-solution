public class Solution {
    public String minWindow(String s,String t) {
        int[] map=new int[128];
        for(Character c:t.toCharArray()) map[c]++;
        int begin=0,end=0,count=s.length(),head=0,min=Integer.MAX_VALUE;
        char[] chars=s.toCharArray();
        while(end<chars.length) {
            if(map[chars[end++]-->0]) count--;
            while(count==0) {
                if(end-begin<min) min=end-(head=begin);
                if(map[chars[begin++]]++==0) count++;
            }
        }
        return min==Integer.MAX_VALUE?"":s.substring(head,head+min);
    }
}
