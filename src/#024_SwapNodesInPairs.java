public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy=new ListNode(0);
        dymmy.next=head;
        ListNode p=head,q;
        ListNode prev=dummy;
        while(p!=null && p.next!=null) {
            q=p.next;
            //swap p and q
            prev.next=q;
            p.next=q.next;
            q.next=p;
            //change prev
            prev=p;
            //change p
            p=p.next;
        }
        return dummy.next;
    }
}
