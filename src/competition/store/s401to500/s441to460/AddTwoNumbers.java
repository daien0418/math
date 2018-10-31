package competition.store.s401to500.s441to460;

import java.util.Stack;

import competition.structure.ListNode;

public class AddTwoNumbers {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		Stack<ListNode> stack1 = new Stack<ListNode>();
		Stack<ListNode> stack2 = new Stack<ListNode>();

		while (l1 != null) {
			stack1.push(l1);
			l1 = l1.next;
		}
		while (l2 != null) {
			stack2.push(l2);
			l2 = l2.next;
		}

		ListNode l3 = null;
		int extra = 0;
		while (!stack1.isEmpty() || !stack2.isEmpty()) {
			ListNode n1 = stack1.isEmpty() ? null : stack1.pop();
			ListNode n2 = stack2.isEmpty() ? null : stack2.pop();
			int v1 = n1 == null ? 0 : n1.val;
			int v2 = n2 == null ? 0 : n2.val;

			ListNode nListNode = new ListNode((v1 + v2 + extra) % 10);
			extra = (v1 + v2 + extra) / 10;
			nListNode.next = l3;
			l3 = nListNode;
		}

		if (extra == 1) {
			ListNode nListNode = new ListNode(1);
			nListNode.next = l3;
			l3 = nListNode;
		}

		return l3;
	}

	public static void main(String[] args) {
		AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
		ListNode l1 = new ListNode(7);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);
		l1.next.next.next = new ListNode(3);

		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);

		ListNode retNode = addTwoNumbers.addTwoNumbers(l1, l2);
		while (retNode != null) {
			System.out.print(retNode.val + "->");
			retNode = retNode.next;
		}
	}

}
