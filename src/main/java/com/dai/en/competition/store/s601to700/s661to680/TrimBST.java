package com.dai.en.competition.store.s601to700.s661to680;

import com.dai.en.competition.structure.TreeNode;

public class TrimBST {

	public TreeNode trimBST(TreeNode root, int L, int R) {
		if (root == null)
			return null;
		if (root.val < L) {
			return trimBST(root.right, L, R);
		} else if (root.val > R) {
			return trimBST(root.left, L, R);
		}
		root.left = trimBST(root.left, L, R);
		root.right = trimBST(root.right, L, R);

		return root;
	}

	public static void main(String[] args) {

	}

}
