package com.dai.en.competition.store.s301to400.s301to320;

import com.dai.en.competition.structure.ListNode;

public class OddEvenList {

	public ListNode oddEvenList(ListNode head) {
		if (head == null)
			return head;
		boolean flag = true;
		ListNode head2 = head.next;

		ListNode h1 = head;
		ListNode h2 = head2;
		while (h2 != null && h2.next != null) {
			if (flag) {
				h1.next = h1.next.next;
				h1 = h1.next;
			} else {
				h2.next = h2.next.next;
				h2 = h2.next;
			}
			flag = !flag;
		}

		h1.next = head2;

		return head;
	}

	public static void main(String[] args) {

	}

}
