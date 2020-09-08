package com.dai.en.competition.store.s401to500.s401to420;

import com.dai.en.competition.structure.TreeNode;

public class SumOfLeftLeaves {

	public int sumOfLeftLeaves(TreeNode root) {
		if (root == null)
			return 0;
		return root.left != null ? (root.left.left == null && root.left.right == null)
				? root.left.val + sumOfLeftLeaves(root.right) : sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right)
				: sumOfLeftLeaves(root.right);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(6);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(4);
		root.left.right.left = new TreeNode(3);
		root.left.right.right = new TreeNode(5);
		root.right = new TreeNode(8);
		root.right.left = new TreeNode(7);
		root.right.right = new TreeNode(9);
		SumOfLeftLeaves sumOfLeftLeaves = new SumOfLeftLeaves();
		System.out.println(sumOfLeftLeaves.sumOfLeftLeaves(root));
	}

}
