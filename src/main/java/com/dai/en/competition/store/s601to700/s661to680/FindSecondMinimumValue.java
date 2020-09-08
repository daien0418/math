package com.dai.en.competition.store.s601to700.s661to680;

import com.dai.en.competition.structure.TreeNode;

public class FindSecondMinimumValue {

	int result = -1;

	public int findSecondMinimumValue(TreeNode root) {
		int val = root.val;
		find(root, val);
		return result;
	}

	private void find(TreeNode root, int val) {
		if (root == null)
			return;
		if (root.val != val) {
			if (result == -1) {
				result = root.val;
			} else {
				result = Math.min(root.val, result);
			}
		} else {
			find(root.left, val);
			find(root.right, val);
		}
	}

	public static void main(String[] args) {

	}

}
