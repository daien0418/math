package competition.store.q20to40;

public class MergeTwoLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode listNode = new ListNode(0);
		ListNode cur=listNode;
		while(l1!=null&&l2!=null){
			if(l1.val>l2.val){
				cur.next = new ListNode(l2.val);
				l2=l2.next;
			}else{
				cur.next = new ListNode(l1.val);
				l1=l1.next;
			}

			cur = cur.next;
		}

		while(l1!=null){
			cur.next=new ListNode(l1.val);
			cur = cur.next;
			l1=l1.next;
		}

		while(l2!=null){
			cur.next=new ListNode(l2.val);
			cur = cur.next;
			l2=l2.next;
		}

		return listNode.next;
    }

}
 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }