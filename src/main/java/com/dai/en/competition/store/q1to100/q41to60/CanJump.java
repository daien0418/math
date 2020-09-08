package com.dai.en.competition.store.q1to100.q41to60;

public class CanJump {

	public boolean canJump(int[] nums) {
		boolean over = false;
		for (int i = nums.length - 1; i >= 0; i--) {
			if (nums[i] == 0 && i != nums.length - 1) {
				over = false;
				for (int j = i; j >= 0; j--) {
					if (nums[j] > i - j) {
						over = true;
						break;
					}
				}
				if (!over) {
					return false;
				}
			}
		}

		return true;
	}

	public static void main(String[] args) {
		CanJump canJump = new CanJump();
		System.out.println(canJump.canJump(new int[] { 1, 0, 0, 1, 1, 2, 2, 0, 2, 2 }));
	}

}
