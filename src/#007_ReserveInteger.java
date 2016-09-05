public class Solution {
    public int reverse(int x) {
        int ans=0;
        int sign=x>0?1:-1;
        x*=sign;
        while(x>0){
            int least=x%10;
            int t=ans;
            ans=ans*10+least;
            int test=(ans-least)/10;
            if(test!=t)return 0;
            x/=10;
        }
        return ans*sign;
    }
}
