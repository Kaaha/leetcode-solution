//solution #1
public class Solution1 {
    public int trap(int[] height) {
        int ans=0;
        int n=height.length;
        if(n==0) return ans;
        int maxLeft=height[0],maxRight=height[n-1];
        int i=0,j=n-1;
        while(i<=j) {
            maxLeft=Math.max(maxLeft,height[i]);
            maxRight=Math.max(maxRight,height[j]);
            if(maxLeft<maxRight) {
                ans+=maxLeft-height[i];
                i++;
            }else {
                ans+=maxRight-height[j];
                j--;
            }
        }
        return ans;
    }
}

//solution #2
public class Solution2 {
    public int trap(int[] height) {
        int ans=0;
        int n=height.length;
        int i=0;
        Stack<Integer> st=new Stack<>();
        while(i<n) {
            if(st.isEmpty() || height[i]<=height[st.peek()]) st.push(i++);
            else {
                int inner=st.pop();
                ans+=st.isEmpty()?0:(Math.max(height[st.peek()],height[i])-height[inner])*(i-st.peek()-1);
            }
        }
        return ans;
    }
}
