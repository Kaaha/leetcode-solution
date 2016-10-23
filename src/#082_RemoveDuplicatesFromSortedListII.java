public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode p=head;
        while(p!=null && p.next!=null) {
            if(p.val==p.next.val) {
                ListNode q=p.next;
                while(q!=null && q.val==p.val) q=q.next;
                p=q;
                pre.next=p;
            }else {
                pre=p;
                p=p.next;
            }
        }
        return dummy.next;
    }
}
