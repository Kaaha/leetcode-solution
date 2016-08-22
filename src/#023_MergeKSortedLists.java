//solution #1:time limited
public class Solution1 {
    public ListNode mergeKLists(ListNode[] lists) {
        int n=lists.length;
        if(n==0) return null;
        ListNode ans=lists[0];
        for(int i=1;i<n;i++) {
            ans=mergeTwoLists(ans,lsits[i]);
        }
        return ans;
    }
    private ListNode mergeTwoLists(ListNode l1,ListNode l2) {
        ListNode dummy=new ListNode(0);
        ListNode first=l2,second=l2;
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

//solution #2:divide and conquer
public class Solution2 {
    public ListNode mergeKLists(ListNode[] lists) {
        int n=lists.length;
        if(n==0) return null;
        return mergeTwoLists(lists,0,n-1);
    }
    private ListNode mergeTwoLists(ListNode[] lists,int l,int r) {
        if(l==r) return lists[l];
        int mid=(l+r)/2;
        ListNode left=mergeTwoLists(lists,l,mid);
        ListNode right=mergeTwoLists(lists,mid+1,r);
        return mergeTwoLists(left,right);
    }
    private ListNode mergeTwoLists(ListNode l1,ListNode l2) {
        ListNode dummy=new ListNode(0);
        ListNode first=l2,second=l2;
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
