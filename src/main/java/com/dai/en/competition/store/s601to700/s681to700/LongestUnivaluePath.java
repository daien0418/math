package com.dai.en.competition.store.s601to700.s681to700;

import com.dai.en.competition.structure.TreeNode;

public class LongestUnivaluePath {

	int result = 0;

	public int longestUnivaluePath(TreeNode root) {
		if (root == null)
			return 0;
		int leftL = maxLength(root.left, root.val);
		int rightL = maxLength(root.right, root.val);

		if (leftL + rightL > result)
			result = leftL + rightL;

		longestUnivaluePath(root.left);
		longestUnivaluePath(root.right);

		return result;
	}

	private int maxLength(TreeNode root, int val) {
		if (root == null)
			return 0;

		if (root.val == val) {
			int leftMax = maxLength(root.left, val);
			int rightMax = maxLength(root.right, val);
			return 1 + Math.max(leftMax, rightMax);
		} else {
			return 0;
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(5);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(5);
		root.left.right.left = new TreeNode(5);

		LongestUnivaluePath longestUnivaluePath = new LongestUnivaluePath();
		System.out.println(longestUnivaluePath.longestUnivaluePath(root));
	}

}
