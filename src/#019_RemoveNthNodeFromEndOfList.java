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
        }
        p.next=p.next.next;
        return dummy.next;
    }
}
