package com.dai.en.competition.store.s201to300.s201to220;

import java.util.HashSet;
import java.util.Set;

public class FindKthLargest {

	public int findKthLargest(int[] nums, int k) {
		Set<Integer> set = new HashSet<Integer>();
		int lastMax = Integer.MAX_VALUE;
		int lastIndex = -1;
		int tempMax = Integer.MIN_VALUE;

		for (int i = 0; i < k; i++) {
			tempMax = Integer.MIN_VALUE;
			lastIndex = -1;
			for (int j = 0; j < nums.length; j++) {
				if (nums[j] > tempMax) {
					if (nums[j] < lastMax) {
						tempMax = nums[j];
						lastIndex = j;
					} else {
						if(!set.contains(j)){
							tempMax = nums[j];
							lastIndex = j;
						}
					}
				}
			}
			lastMax = tempMax;
			set.add(lastIndex);
		}

		return tempMax;
	}

	public static void main(String args[]) {
		FindKthLargest findKthLargest = new FindKthLargest();
		int result = findKthLargest.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4);
		System.out.println(result);
	}

}
