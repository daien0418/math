package com.dai.en.competition.store.s101to200.s141to160;

import com.dai.en.competition.structure.ListNode;

public class ReorderList {

	public void reorderList(ListNode head) {

		if (head == null || head.next == null)
			return;

		ListNode fast = head;
		ListNode slow = head;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		ListNode revertHead = slow.next;
		slow.next = null;
		ListNode head2 = revert(revertHead);
		ListNode head1 = head;

		while (head1 != null && head2 != null) {
			ListNode temp = head2.next;
			head2.next = head1.next;
			head1.next = head2;
			head1 = head2.next;
			head2 = temp;
		}
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
		ReorderList reorderList = new ReorderList();
		ListNode root = new ListNode(1);
		root.next = new ListNode(2);
		root.next.next = new ListNode(3);
		// root.next.next.next = new ListNode(4);
		reorderList.reorderList(root);

		while (root != null) {
			System.out.print(root.val);
			System.out.print("->");
			root = root.next;
		}
	}

}
