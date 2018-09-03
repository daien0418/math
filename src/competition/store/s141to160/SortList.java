package competition.store.s141to160;

import competition.structure.ListNode;

public class SortList {

	public ListNode sortList(ListNode head) {
		return deperate(head);
	}

	private ListNode deperate(ListNode head) {
		if (head == null)
			return null;
		if (head.next == null)
			return head;
		ListNode slow = head;
		ListNode fast = head;

		while (fast != null) {
			if (fast.next == null || fast.next.next == null) {
				break;
			}
			fast = fast.next.next;
			slow = slow.next;
		}

		ListNode mid = slow.next;
		slow.next = null;

		ListNode first = deperate(head);
		ListNode second = deperate(mid);
		return merge(first, second);
	}

	private ListNode merge(ListNode sNode, ListNode eNode) {
		if (sNode == null)
			return eNode;
		if (eNode == null)
			return sNode;
		ListNode head = null;
		ListNode temp = null;
		while (sNode != null && eNode != null) {
			if (sNode.val > eNode.val) {
				if (head == null) {
					head = eNode;
					temp = head;
				} else {
					temp.next = eNode;
					temp = temp.next;
				}
				eNode = eNode.next;
			} else {
				if (head == null) {
					head = sNode;
					temp = head;
				} else {
					temp.next = sNode;
					temp = temp.next;
				}
				sNode = sNode.next;
			}
		}

		if (sNode != null) {
			temp.next = sNode;
		}

		if (eNode != null) {
			temp.next = eNode;
		}

		return head;
	}

	public static void main(String[] args) {
		SortList sortList = new SortList();
		ListNode head = new ListNode(4);
		head.next = new ListNode(1);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(2);
		ListNode retH = sortList.sortList(head);
		while (retH != null) {
			System.out.println(retH.val);
			retH = retH.next;
		}
	}

}
