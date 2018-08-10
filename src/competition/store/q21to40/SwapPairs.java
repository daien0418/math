package competition.store.q21to40;

public class SwapPairs {
	public ListNode swapPairs(ListNode head) {
		if(head==null||head.next==null) return head;
		ListNode vir = new ListNode(0);
		vir.next = head;
		ListNode ret = vir;

		ListNode tail =head.next;
		while(head!=null&&tail!=null){
			head.next = tail.next;
			tail.next=head;
			vir.next = tail;

			vir = head;
			head=head.next;
			tail=head==null?null:head.next;
		}

		return ret.next;
    }

	class ListNode {
		  int val;
		  ListNode next;
		  ListNode(int x) { val = x; }
	}
}

