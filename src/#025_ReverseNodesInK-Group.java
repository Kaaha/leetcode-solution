public class Solution {
    public ListNode reverseKGroup(ListNode head,int k) {
        if(k==1) return head;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode p,q;
        ListNode prev=dummy,end=head;
        int steps=0;
        while(end!=null) {
            while(steps%k!=k-1 && end!=null) {
                end=end.next;
                steps++;
            }
            if(end==null) return dummy.next;
            steps++;end=end.next;
            p=prev.next;
            while(p!=end && p.next!=end) {
                q=p.next;
                ListNode temp=prev.next;
                prev.next=q;
                p.next=q.next;
                q.next=temp;
            }
            prev=p;
        }
        return dummy.next;
    }
}
