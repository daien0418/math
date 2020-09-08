package com.dai.en.competition.store.q1to100.q81to100;

import com.dai.en.competition.structure.TreeNode;

public class RecoverTree {

	TreeNode leftN = null;
	TreeNode rightN = null;

	public void recoverTree(TreeNode root) {
		if (root == null)
			return;
		sLeft(root.left, root.val);
		sRight(root.right, root.val);
		if (leftN != null || rightN != null) {
			if (leftN == null) {
				leftN = root;
			}
			if (rightN == null) {
				rightN = root;
			}
			int temp = leftN.val;
			leftN.val = rightN.val;
			rightN.val = temp;
			return;
		}
		recoverTree(root.left);
		if (leftN != null || rightN != null) {
			return;
		}
		recoverTree(root.right);
		if (leftN != null || rightN != null) {
			return;
		}
	}

	private void sLeft(TreeNode root, int val) {
		if (root == null)
			return;
		if (root.val > val) {
			if (leftN == null) {
				leftN = root;
			} else {
				leftN = leftN.val > root.val ? leftN : root;
			}
		}
		sLeft(root.left, val);
		sLeft(root.right, val);
	}

	private void sRight(TreeNode root, int val) {
		if (root == null)
			return;

		if (root.val < val) {
			if (rightN == null) {
				rightN = root;
			} else {
				rightN = rightN.val < root.val ? rightN : root;
			}
		}
		sRight(root.left, val);
		sRight(root.right, val);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(3);
		root.right.right = new TreeNode(2);
		RecoverTree recoverTree = new RecoverTree();
		recoverTree.recoverTree(root);
		System.out.println(root.val);
	}

}
