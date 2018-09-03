package competition.store.s141to160;

import competition.structure.ListNode;

public class InsertionSortList {

	public ListNode insertionSortList(ListNode head) {
		ListNode retHead = new ListNode(Integer.MIN_VALUE);

		while (head != null) {

			ListNode temp = retHead;
			while (temp.next != null) {
				if (head.val > temp.next.val) {
					temp = temp.next;
				} else {
					ListNode newNode = new ListNode(head.val);
					newNode.next = temp.next;
					temp.next = newNode;
					break;
				}
			}

			if (temp.next == null) {
				temp.next = new ListNode(head.val);
			}

			head = head.next;
		}

		return retHead.next;
	}

	public static void main(String[] args) {
		InsertionSortList insertionSortList = new InsertionSortList();
		ListNode head = new ListNode(4);
		head.next = new ListNode(1);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(2);
		ListNode ret = insertionSortList.insertionSortList(head);
		while (ret != null) {
			System.out.println(ret.val);
			ret=ret.next;
		}
	}

}
