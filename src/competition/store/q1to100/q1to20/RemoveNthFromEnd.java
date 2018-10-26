package competition.store.q1to100.q1to20;

public class RemoveNthFromEnd {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode tail = head;
		int i=0;
		while(tail!=null&&i<n){
			tail = tail.next;
			i++;
		}
		if(i!=n){
			return head;
		}

		ListNode h = new ListNode(0);
		h.next=head;
		head = h;
		while(tail!=null){
			h =h.next;
			tail=tail.next;
		}

		h.next = h.next.next;
		return head.next;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}