package competition.store.s121to140;

import competition.structure.RandomListNode;

public class CopyRandomList {

	public RandomListNode copyRandomList(RandomListNode head) {
		RandomListNode randomListNode = head==null?null:new RandomListNode(head.label);

		while(head!=null){
			if(head.next!=null){
				randomListNode.next = new RandomListNode(head.next.label);
			}
			head=head.next;
			randomListNode = randomListNode.next;
		}

		return randomListNode;
	}

	public static void main(String[] args) {

	}

}
