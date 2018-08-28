package competition.store.q81to100;

import competition.structure.ListNode;

public class DeleteDuplicates2 {

	public ListNode deleteDuplicates(ListNode head) {
		ListNode vir = new ListNode(Integer.MAX_VALUE);
		vir.next = head;

		ListNode pre = vir;
		int lastVal = vir.val;

		while (head!= null) {

			if (head.val != lastVal) {
				if (head.next==null||head.val != head.next.val) {
					pre.next = head;
					pre = head;
					lastVal = pre.val;
				}else{
					lastVal = head.val;
				}
			}

			head = head.next;
		}

		pre.next = null;
		return vir.next;
	}

	public static void main(String[] args) {

	}

}
