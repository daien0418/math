package com.dai.en.competition.store.s101to200.s141to160;

public class FindMin {

	public int findMin(int[] nums) {
		int last = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < last) {
				return nums[i];
			} else {
				last = nums[i];
			}
		}

		return nums[0];
	}

	public static void main(String[] args) {
		FindMin findMin = new FindMin();
		System.out.println(findMin.findMin(new int[] { 4, 5, 6, 7, 0, 1, 2 }));
	}

}
