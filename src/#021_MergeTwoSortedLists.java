//solution #1
public class Solution1 {
    public ListNode mergeTwoLists(ListNode l1,ListNode l2) {
        ListNode dummy=new ListNode(0);
        ListNode first=l1,second=l2;
        ListNode p=dummy;
        while(first!=null && second!=null) {
            ListNode curr=new ListNode(0);
            if(first.val<second.val) {
                curr.val=first.val;
                first=first.next;
                p.next=curr;
                p=p.next;
            }else {
                curr.val=second.val;
                second=second.next;
                p.next=curr;
                p=p.next;
            }
        }
        while(first!=null) {
            ListNode curr=new ListNode(first.val);
            p.next=curr;
            p=p.next;
            first=first.next;
        }
        while(second!=null) {
            ListNode curr=new ListNode(second.val);
            p.next=curr;
            p=p.next;
            second=second.next;
        }
        return dummy.next;
    }
}
