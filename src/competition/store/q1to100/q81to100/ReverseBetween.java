package competition.store.q1to100.q81to100;

import competition.structure.ListNode;

public class ReverseBetween {

	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode vir = new ListNode(0);
		vir.next = head;
		ListNode ret = vir;

//		if(m>=n) return ret.next;   //ø…“‘»•µÙ

		int times = 0;
		while(times<m-1){
			vir = vir.next;
			times++;
		}

		ListNode h = vir;
		ListNode t = vir.next;
		ListNode pre = vir.next;
		ListNode aft = pre.next;
		ListNode temp = null;

		times = 1;
		while(times<=n-m){
			temp = aft.next;
			aft.next = pre;
			pre = aft;
			aft = temp;
			times++;
		}

		h.next = pre;
		t.next = aft;

		return ret.next;
	}
}

