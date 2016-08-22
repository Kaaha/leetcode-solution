//solution #1
public class Solution1 {
    public ListNode reverseList(ListNode head) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode p=dummy.next,q;
        while(p!=null && p.next!=null) {
            q=p.next;
            ListNode temp=dummy.next;
            dummy.next=q;
            p.next=q.next;
            q.next=temp;
        }
        return dummy.next;
    }
}
