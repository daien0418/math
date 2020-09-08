package com.dai.en.competition.store.s201to300.s221to240;

import com.dai.en.competition.structure.ListNode;

public class IsPalindrome {

	public boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null) {
			return true;
		}

		ListNode fast = head;
		ListNode slow = head;

		while(fast.next!=null&&fast.next.next!=null){
			slow = slow.next;
			fast = fast.next.next;
		}

		ListNode revertHead = slow.next;
		slow.next = null;
		ListNode head2 = revert(revertHead);
		ListNode head1 = head;

		while(head1 != null && head2 != null){
			if(head1.val!=head2.val){
				return false;
			}
			head1 = head1.next;
			head2 = head2.next;
		}

		return true;
	}

	private ListNode revert(ListNode head) {

		if (head == null || head.next == null) {
			return head;
		}

		ListNode pre = head;
		ListNode aft = head.next == null ? head : head.next;
		pre.next = null;

		while (aft != null) {
			ListNode temp = aft.next;
			aft.next = pre;
			pre = aft;
			aft = temp;
		}

		return pre;
	}

	public static void main(String[] args) {

	}

}
