package com.dai.en.competition.store.s101to200.s141to160;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.dai.en.competition.structure.TreeNode;

public class PostorderTraversal {

	/**
	 * µü´ú
	 *
	 * @param root
	 * @return
	 */
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if (root != null)
			stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.peek();
			if (node.left == null && node.right == null) {
				list.add(node.val);
				stack.pop();
			} else {
				if (node.right != null)
					stack.push(node.right);
				if (node.left != null)
					stack.push(node.left);
				node.right = null;
				node.left = null;
			}
		}

		return list;
	}

	public static void main(String[] args) {

	}

}
