package competition.store.s101to200.s121to140;

import competition.structure.RandomListNode;

public class CopyRandomList {

	public RandomListNode copyRandomList(RandomListNode head) {
		RandomListNode randomListNode = head==null?null:new RandomListNode(head.label);
		
		RandomListNode virtual = new RandomListNode(0);
		virtual.next = randomListNode;
		
		RandomListNode virtual2 =  new RandomListNode(0);
		virtual2.next = head;
		
		while(head!=null){
			if(head.next!=null){
				randomListNode.next = new RandomListNode(head.next.label);
			}
			head=head.next;
			randomListNode = randomListNode.next;
		}

		randomListNode = virtual.next;
		head = virtual2.next;
		
		while(head!=null){
			if(head.random!=null){
				randomListNode.random = find(virtual.next, virtual2.next, head.random);
			}
			
			head =head.next;
			randomListNode = randomListNode.next;
		}
		
		return virtual.next;
	}

	private RandomListNode find(RandomListNode copyHead,RandomListNode head,RandomListNode randomNode){
		while(head!=null){
			if(head == randomNode){
				return copyHead;
			}
			head = head.next;
			copyHead = copyHead.next;
		}
		
		return null;
	}
	
	public static void main(String[] args) {

	}

}
