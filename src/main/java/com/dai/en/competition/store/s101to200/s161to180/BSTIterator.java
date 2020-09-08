package com.dai.en.competition.store.s101to200.s161to180;

import java.util.Stack;

import com.dai.en.competition.structure.TreeNode;

public class BSTIterator {

	Stack<TreeNode> stack = new Stack<TreeNode>();

	public BSTIterator(TreeNode root) {
		while (root != null) {
			stack.push(root);
			root = root.left;
		}
	}

	public boolean hasNext() {
		return !stack.isEmpty();
	}

	public int next() {
		TreeNode first = stack.pop();
		int val = first.val;

		TreeNode tempRoot = first.right;

		while (tempRoot != null) {
			stack.push(tempRoot);
			tempRoot = tempRoot.left;
		}

		return val;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(7);
		root.left = new TreeNode(4);
		root.right = new TreeNode(9);
		root.right.left = new TreeNode(8);
		root.right.right = new TreeNode(10);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(6);
		root.left.right.left = new TreeNode(5);

		BSTIterator bstIterator = new BSTIterator(root);
		while (bstIterator.hasNext()) {
			System.out.println(bstIterator.next());
		}
	}

}
