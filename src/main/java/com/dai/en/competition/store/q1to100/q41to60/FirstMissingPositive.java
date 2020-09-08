package com.dai.en.competition.store.q1to100.q41to60;

public class FirstMissingPositive {

	public int firstMissingPositive(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 1;
		}

		for (int i = 0; i < nums.length;) {
			if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
				int temp = nums[nums[i] - 1];
				nums[nums[i] - 1] = nums[i];
				nums[i] = temp;
			} else {
				i++;
			}
		}

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != i + 1) {
				return i + 1;
			}
		}

		return nums.length + 1;
	}

	public static void main(String[] args) {
		FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
		int[] nums = new int[] { 1, 1 };
		int ret = firstMissingPositive.firstMissingPositive(nums);
		System.out.println(ret);
	}

}
