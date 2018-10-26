package competition.store.q1to100.q21to40;

import competition.structure.ListNode;

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

}

