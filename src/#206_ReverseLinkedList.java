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

//solution #2
public class Solution2 {
    public ListNode reverseList(ListNode head) {
        ListNode newHead=null;
        while(head!=null) {
            ListNode next=head.next;
            head.next=newHead;
            newHead=head;
            head=next;
        }
        return newHead;
    }
}

//solution #3
public class Solution3 {
    public ListNode reverseList(ListNode head) {
        return reverseList(head,null);
    }
    private ListNode reverseList(ListNode head,ListNode newHead) {
        if(head==null) return newHead;
        ListNode next=head.next;
        head.next=newHead;
        return reverseList(next,head);
    }
}
