package com.dai.en.competition.store.q1to100.q81to100;

import com.dai.en.competition.structure.ListNode;

public class DeleteDuplicates {

	public ListNode deleteDuplicates(ListNode head) {
		ListNode ret  =head;
		ListNode cur = null;
		while(head!=null){
			if(cur==null){
				cur = head;
				head = head.next;
				continue;
			}

			if(head.val == cur.val){
				cur.next = head.next;
				head.next = null;
				head = cur.next;
			}else{
				cur = head;
				head=cur.next;
			}
		}

		return ret;
	}

	public static void main(String[] args) {

	}

}
