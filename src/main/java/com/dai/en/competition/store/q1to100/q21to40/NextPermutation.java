package com.dai.en.competition.store.q1to100.q21to40;

public class NextPermutation {

	public void nextPermutation(int[] nums) {
		if (nums == null || nums.length <= 1)
			return;
		int len = nums.length;
		int j = -1;
		for (int i = len - 1; i > 0; i--) {
			if (nums[i] > nums[i - 1]) {
				j = i - 1;
				break;
			}
		}

		if (j != -1) {
			int minIndex = 0;
			for (int i = len - 1; i >= j + 1; i--) {
				if (nums[i] > nums[j]) {
					minIndex = i;
					break;
				}
			}
			int temp = nums[j];
			nums[j] = nums[minIndex];
			nums[minIndex] = temp;
		}

		int mid = (j + 1 + len - 1) / 2;
		int sum = j + 1 + len - 1;
		int temp = 0;
		for (int i = j + 1; i <= mid; i++) {
			temp = nums[i];
			nums[i] = nums[sum - i];
			nums[sum - i] = temp;
		}
	}

	public static void main(String[] args) {
		NextPermutation nextPermutation= new NextPermutation();
		nextPermutation.nextPermutation(new int[]{1,2,3});
	}

}
