package com.dai.en.competition.store.q1to100.q81to100;

import java.util.ArrayList;
import java.util.List;

import com.dai.en.competition.structure.ListNode;

public class Partition {

	public ListNode partition(ListNode head, int x) {
		List<ListNode> less = new ArrayList<ListNode>();
		List<ListNode> more = new ArrayList<ListNode>();
		ListNode temp = null;

		while (head != null) {
			temp = head.next;
			head.next = null;
			if (head.val < x) {
				less.add(head);
			} else {
				more.add(head);
			}
			head = temp;
		}

		ListNode lHead = null;
		ListNode lLast = null;
		for (ListNode node :less) {
			if(lHead == null){
				lHead = node;
			}
			if (lLast == null) {
				lLast = node;
			}else{
				lLast.next = node;
				lLast = node;
			}
		}

		ListNode mHead = null;
		ListNode mLast = null;
		for (ListNode node:more) {
			if(mHead == null){
				mHead = node;
			}
			if(mLast==null){
				mLast = node;
			}else{
				mLast.next = node;
				mLast = node;
			}
		}

		if (lLast != null) {
			lLast.next = mHead;
		}

		return lHead == null ? mHead : lHead;
	}

	public static void main(String[] args) {

	}

}
