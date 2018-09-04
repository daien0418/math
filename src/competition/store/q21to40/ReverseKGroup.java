package competition.store.q21to40;

import competition.structure.ListNode;

public class ReverseKGroup {

	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode vir = new ListNode(0);
		ListNode ppre = vir;
		ListNode aaft = null;
		ListNode pre = head;
		ListNode aft = head;
		int sum=1;

		while (pre!=null&&aft.next != null) {
			aft=aft.next;
			sum++;
			if(sum==k){
				aaft = aft.next;
			}
		}

		return null;
	}

	public static void main(String[] args) {

	}

}
