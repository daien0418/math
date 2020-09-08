package com.dai.en.competition.store.s801to900.s801to820;

import com.dai.en.competition.structure.TreeNode;

public class PruneTree {

	public TreeNode pruneTree(TreeNode root) {
		if (isZero(root))
			return null;
		if (isZero(root.left)) {
			root.left = null;
		} else {
			pruneTree(root.left);
		}
		if (isZero(root.right)) {
			root.right = null;
		} else {
			pruneTree(root.right);
		}
		return root;
	}

	private boolean isZero(TreeNode root) {
		if (root == null)
			return true;
		if (root.val == 1)
			return false;
		return isZero(root.left) && isZero(root.right);
	}

	public static void main(String[] args) {

	}

}
