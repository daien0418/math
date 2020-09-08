package com.dai.en.competition.store.s101to200.s101to120;

import java.util.Stack;

import javax.print.attribute.standard.Sides;

import com.dai.en.competition.structure.TreeNode;

public class MaxDepth {

	public int maxDepth(TreeNode root) {
		int ret = 0;
		Stack<TreeNode> s1 = new Stack<TreeNode>();
		Stack<TreeNode> s2 = new Stack<TreeNode>();
		if (root != null)
			s1.push(root);

		TreeNode node = null;
		while (!s1.isEmpty()) {
			ret++;
			while (!s1.isEmpty()) {
				node = s1.pop();
				if (node.left != null)
					s2.push(node.left);
				if (node.right != null)
					s2.push(node.right);
			}

			while (!s2.isEmpty()) {
				s1.push(s2.pop());
			}
		}
		return ret;
	}

	public static void main(String[] args) {

	}

}
