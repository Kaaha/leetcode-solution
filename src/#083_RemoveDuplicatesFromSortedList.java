public class Solution {
    public ListNode removeDuplicates(ListNode head) {
        if(head==null) return head;
        ListNode p=head,q=p.next;
        while(q!=null) {
            if(p.val==q.val) {
                p.next=q.next;
                q=p.next;
            }else {
                p=q;
                q=p.next;
            }
        }
        return head;
    }
}
