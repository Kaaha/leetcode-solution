public class Solution {
    String getPermutation(int n,int k){
        StringBuilder sb=new StringBuilder();
        List<Integer> digits=new ArrayList<>();
        int[] fact=new int[n+1];
        fact[0]=1;
        for(int i=1;i<=n;i++) {
            fact[i]=fact[i-1]*i;
            digits.add(i);
        }
        k--;
        for(int i=n-1;i>=0;i--) {
            int index=k/fact[i];
            sb.append(digits.get(index));
            digits.remove(index);
        }
        return sb.toString();
    }
}
