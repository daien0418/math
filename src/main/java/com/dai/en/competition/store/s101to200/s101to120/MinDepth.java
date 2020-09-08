package com.dai.en.competition.store.s101to200.s101to120;

import java.util.Stack;

import com.dai.en.competition.structure.TreeNode;

public class MinDepth {

	public int minDepth(TreeNode root) {
		if (root == null)
			return 0;

		int ret = 1;
		Stack<TreeNode> s1 = new Stack<TreeNode>();
		Stack<TreeNode> s2 = new Stack<TreeNode>();
		s1.push(root);

		while (true) {
			while (!s1.isEmpty()) {
				root = s1.pop();
				if (root.left == null && root.right == null) {
					return ret;
				}
				if (root.left != null)
					s2.push(root.left);
				if (root.right != null)
					s2.push(root.right);
			}

			while (!s2.isEmpty()) {
				s1.push(s2.pop());
			}
			ret++;
		}

		// return ret;
	}

	public static void main(String[] args) {

	}

}

