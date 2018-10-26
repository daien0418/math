package competition.store.s201to300.s201to220;

import competition.structure.ListNode;

public class ReverseList {

	/**
	 * µü´ú
	 *
	 * @param head
	 * @return
	 */
	public ListNode reverseList(ListNode head) {
		if (head == null)
			return head;
		ListNode pre = null;
		ListNode temp = null;

		while (head != null) {
			temp = head.next;
			head.next = pre;
			pre = head;
			head = temp;
		}

		return pre;
	}

	/**
	 * µÝ¹é
	 *
	 * @param head
	 * @return
	 */
	ListNode hListNode;

	public ListNode reverseList2(ListNode head) {
		if (head == null)
			return head;
		if (head.next == null) {
			hListNode = head;
			return head;
		}

		ListNode temp = head.next;
		head.next = null;

		reverseList2(temp).next = head;
		return head;
	}

	public static void main(String args[]) {
		ListNode root = new ListNode(5);
		ListNode root1 = new ListNode(4);
		ListNode root2 = new ListNode(3);
		ListNode root3 = new ListNode(2);
		ListNode root4 = new ListNode(1);

		root.next = root1;
		root1.next = root2;
		root2.next = root3;
		root3.next = root4;

		ReverseList reverseList = new ReverseList();
		reverseList.reverseList2(root);
		System.out.println(reverseList.hListNode);
	}

}

