package competition.store.q1to20;

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

		ListNode h = head;
		while(tail.next!=null){
			h =h.next;
			tail=tail.next;
		}

		h.next = h.next.next;
		return head;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}