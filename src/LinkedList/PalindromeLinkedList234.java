package LinkedList;

import Model.ListNode;

import java.util.List;

public class PalindromeLinkedList234 {
    ListNode root=null;
    public boolean isPalindrome(ListNode head) {
        root=head;
        return helper(head);
    }

    public  boolean helper(ListNode p){
        if(p==null)  return true;
        boolean res=helper(p.next);
        res=res&&(root.val==p.val);
        root=root.next;
        return res;
    }
}
