package com.dai.en.competition.store.q1to100.q21to40;

import com.dai.en.competition.structure.ListNode;

public class MergeKLists {

	public ListNode mergeKLists(ListNode[] lists) {
		ListNode head = new ListNode(-1);
		ListNode listNode = head;

		int index = -1;
		int currentVal = -1;
		while (true) {
			index = -1;
			currentVal = Integer.MAX_VALUE;
			for (int i = 0; i < lists.length; i++) {
				if (lists[i] != null && lists[i].val < currentVal) {
					currentVal = lists[i].val;
					index = i;
				}
			}

			if (index == -1) {
				break;
			} else {
				listNode.next = lists[index];
				lists[index] = lists[index].next;
				listNode = listNode.next;
			}
		}

		return head.next;
	}

	public static void main(String args[]) {
		MergeKLists mergeKLists = new MergeKLists();
		ListNode aRoot = new ListNode(1);
		aRoot.next = new ListNode(4);
		aRoot.next.next = new ListNode(5);

		ListNode bRoot = new ListNode(1);
		bRoot.next = new ListNode(3);
		bRoot.next.next = new ListNode(4);

		ListNode cRoot = new ListNode(2);
		cRoot.next = new ListNode(6);

		ListNode[] lists = new ListNode[] { aRoot, bRoot, cRoot };
		ListNode retList = mergeKLists.mergeKLists(lists);

		while (retList != null) {
			System.out.print(retList.val);
			System.out.print(",");
			retList = retList.next;
		}
	}

}
