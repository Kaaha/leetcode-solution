public class Solution {
    public int lengthOfLastWord(String s) {
        String ss=s.trim();
        String[] strs=ss.split(" ");
        return strs[strs.length-1].length();
    }
}
