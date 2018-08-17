package competition.store.q61to80;

public class RotateRight {

	public ListNode rotateRight(ListNode head, int k) {
		if(k==0) return head;
		if(head == null) return head;

		int length = 1;
		ListNode h = head;
		while(h.next!=null){
			length++;
			h=h.next;
		}

		ListNode tail = h;
		tail.next = head;

		int times = length-k%length;
		while(times>0){
			tail=head;
			head=head.next;
			times--;
		}

		tail.next=null;

		return head;
	}

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
