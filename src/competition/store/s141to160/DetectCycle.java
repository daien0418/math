package competition.store.s141to160;

import competition.structure.ListNode;

public class DetectCycle {

	public ListNode detectCycle(ListNode head) {
		if(head==null) return null;

		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				fast=head;
				while(slow!=fast){
					slow=slow.next;
					fast=fast.next;
				}
				break;
			}
		}

		if (fast.next == null||fast.next.next==null) {
			return null;
		}

		return slow;
	}

	public static void main(String[] args) {
		DetectCycle detectCycle = new DetectCycle();
		detectCycle.detectCycle(new ListNode(1));
	}

}
