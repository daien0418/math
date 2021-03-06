package com.dai.en.competition.store.s601to700.s681to700;

import com.dai.en.competition.structure.TreeNode;

public class SearchBST {

	public TreeNode searchBST(TreeNode root, int val) {

		while (root != null) {
			if (root.val == val) {
				return root;
			} else if (root.val > val) {
				root = root.left;
			} else {
				root = root.right;
			}
		}

		return null;
	}

}
