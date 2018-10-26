package competition.store.s101to200.s141to160;

import competition.structure.ListNode;

public class HasCycle {

	public boolean hasCycle(ListNode head) {
		if(head==null||head.next==null)return false;
        ListNode fast=head,slow=head;
        while(fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow)return true;
        }
        return false;
    }


	public static void main(String[] args) {
		HasCycle hasCycle = new HasCycle();
		ListNode listNode = new ListNode(0);
		ListNode listNode2 = new ListNode(1);

		listNode.next = listNode2;
		listNode2.next = listNode;
	}

}
