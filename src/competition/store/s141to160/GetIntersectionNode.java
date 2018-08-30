package competition.store.s141to160;

import competition.structure.ListNode;

public class GetIntersectionNode {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}
		ListNode hA = headA;
		ListNode hB = headB;
		while (hA != null) {
			if (hB == hA) {
				return hA;
			} else {
				hB = hB.next;
				if (hB == null) {
					hA = hA.next;
					hB = headB;
				}
			}
		}

		return null;
	}

	public static void main(String[] args) {

	}

}
