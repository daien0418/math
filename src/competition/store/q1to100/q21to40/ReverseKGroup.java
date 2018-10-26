package competition.store.q1to100.q21to40;

import competition.structure.ListNode;

public class ReverseKGroup {

	public ListNode reverseKGroup(ListNode head, int k) {
		if (k <= 1)
			return head;
		ListNode vir = new ListNode(0);
		vir.next = head;
		ListNode ppre = vir;
		ListNode aaft = null;
		ListNode pre = head;
		ListNode aft = head;
		int sum = 1;

		while (pre != null && aft.next != null) {
			aft = aft.next;
			sum++;
			if (sum == k) {
				aaft = aft.next;
				reverse(pre, aft);
				ppre.next = aft;
				pre.next = aaft;

				ppre = pre;
				pre = aaft;
				aft = aaft;
				sum = 1;
			}
		}

		return vir.next;
	}

	private void reverse(ListNode pre, ListNode aft) {
		ListNode cur = pre;
		ListNode a = pre.next;
		ListNode last = null;

		while (cur != aft) {
			cur.next = last;
			last = cur;
			cur = a;
			a = a.next;
		}
		cur.next = last;
	}

	public static void main(String[] args) {
		ListNode root = new ListNode(1);
		root.next=new ListNode(2);
		root.next.next=new ListNode(3);
		root.next.next.next = new ListNode(4);
		root.next.next.next.next = new ListNode(5);

		ReverseKGroup reverseKGroup =  new ReverseKGroup();
		ListNode ret = reverseKGroup.reverseKGroup(root, 2);
		while(ret!=null){
			System.out.println(ret.val);
			ret=ret.next;
		}
	}

}
