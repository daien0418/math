package com.dai.en.competition.store.s601to700.s601to620;

import com.dai.en.competition.structure.TreeNode;

public class MergeTrees {

	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		if (t1 == null && t2 == null)
			return null;
		TreeNode root = new TreeNode(t1 == null ? t2.val : t2 == null ? t1.val : t1.val + t2.val);
		root.left = mergeTrees(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
		root.right = mergeTrees(t1 == null ? null : t1.right, t2 == null ? null : t2.right);
		return root;
	}

	public static void main(String[] args) {

	}

}
