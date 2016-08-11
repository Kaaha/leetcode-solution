//solution #1:two pass
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution1 {
    public ListNode removeNthFromEnd(ListNode head,int n){
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        int len=0;
        ListNode p=head;
        while(p!=null){
            len++;
            p=p.next;
        }
        p=dummy;
        len-=n;
        while(len>0){
            p=p.next;
            len--;
        }
        p.next=p.next.next;
        return dummy.next;
    }
}

//solution #2:one pass by two pointers
public class Solution2{
    public ListNode removeNthFromEnd(ListNode head,int n){
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode first=dummy,second=dummy;
        for(int i=0;i<=n && first!=null;i++) first=first.next;
        while(first!=null){
            first=first.next;
            second=second.next;
        }
        second.next=second.next.next;
        return dummy.next;
    }
}
