package com.dai.en.competition.store.s101to200.s141to160;

public class FindMin2 {

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
		FindMin2 findMin = new FindMin2();
		System.out.println(findMin.findMin(new int[] { 2, 2, 2, 0, 1 }));
	}

}
