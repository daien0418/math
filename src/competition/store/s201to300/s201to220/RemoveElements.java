package competition.store.s201to300.s201to220;

import competition.structure.ListNode;

public class RemoveElements {

	public ListNode removeElements(ListNode head, int val) {
		ListNode ret = new ListNode(-1);
		ret.next = head;
		head = ret;

		while(head.next!=null){
			if(head.next.val==val){
				head.next = head.next.next;
			}else{
				head = head.next;
			}
		}

		return ret.next;
	}

	public static void main(String[] args) {

	}

}
