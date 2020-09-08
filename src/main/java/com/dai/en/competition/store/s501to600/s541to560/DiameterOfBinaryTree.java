package com.dai.en.competition.store.s501to600.s541to560;

import com.dai.en.competition.structure.TreeNode;

public class DiameterOfBinaryTree {

	int path = 0;

	public int diameterOfBinaryTree(TreeNode root) {
		depth(root);
		return path;
	}

	private int depth(TreeNode root) {
		if (root == null)
			return 0;
		int leftD = depth(root.left);
		int rightD = depth(root.right);
		if (leftD + rightD > path) {
			path = leftD + rightD;
		}
		return 1 + Math.max(leftD, rightD);
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

		DiameterOfBinaryTree diameterOfBinaryTree = new DiameterOfBinaryTree();
		int dep = diameterOfBinaryTree.diameterOfBinaryTree(root);
		System.out.println(dep);
		System.out.println(diameterOfBinaryTree.path);
	}

}
