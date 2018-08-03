package competition.contest95;

public class MiddleNode {
	public ListNode middleNode(ListNode head) {
		ListNode ret=head;
		int length=0;
		while(head!=null){
			head= head.next;
			length++;
		}

		int half=0;
		while(half<length/2){
			ret=ret.next;
			half++;
		}

		return ret;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}