package com.dai.en.competition.store.s101to200.s141to160;

import com.dai.en.competition.structure.ListNode;

public class GetIntersectionNode {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}
		ListNode hA = headA;
		ListNode hB = headB;
		int aLen = 0;
		int bLen = 0;
		while (hA != null) {
			aLen++;
			hA = hA.next;
		}
		while (hB != null) {
			bLen++;
			hB = hB.next;
		}

		hA = headA;
		hB = headB;
		int dep = 0;
		if (aLen > bLen) {
			while (dep < aLen - bLen) {
				dep++;
				hA = hA.next;
			}
		} else {
			while (dep < bLen - aLen) {
				dep++;
				hB = hB.next;
			}
		}

		while (hA != null && hB != null) {
			if (hA == hB) {
				return hA;
			}
			hA = hA.next;
			hB = hB.next;
		}

		return null;
	}

	public static void main(String[] args) {

	}

}
