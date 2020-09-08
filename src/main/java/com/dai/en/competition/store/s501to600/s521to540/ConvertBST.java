package com.dai.en.competition.store.s501to600.s521to540;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import com.dai.en.competition.structure.TreeNode;

public class ConvertBST {

	public TreeNode convertBST(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		Set<TreeNode> set = new HashSet<TreeNode>();
		if (root != null)
			stack.push(root);
		int initV = 0;
		while (!stack.isEmpty()) {
			TreeNode popNode = stack.pop();
			if (popNode == null) {
				continue;
			}
			if (set.contains(popNode)) {
				popNode.val = popNode.val + initV;
				initV = popNode.val;
			} else {
				if (popNode.left == null && popNode.right == null) {
					popNode.val = popNode.val + initV;
					initV = popNode.val;
				} else {
					stack.push(popNode.left);
					stack.push(popNode);
					stack.push(popNode.right);
				}
			}
			set.add(popNode);
		}

		return root;
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

		ConvertBST convertBST = new ConvertBST();
		TreeNode rNode = convertBST.convertBST(root);
		System.out.println(rNode.val);
	}

}
