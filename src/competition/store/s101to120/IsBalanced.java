package competition.store.s101to120;

import java.util.Stack;

import competition.store.s101to120.IsSymmetric.TreeNode;

public class IsBalanced {

	public boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
		return compare(root.left, root.right);
	}

	private boolean compare(TreeNode left, TreeNode right) {
		if (left == null && right == null) {
			return true;
		}

		if (Math.abs(depth(left) - depth(right)) >= 2) {
			return false;
		} else {
			if (left == null) {
				return compare(right.left, right.right);
			}
			if (right == null) {
				return compare(left.left, left.right);
			}
			return compare(left.left, left.right) && compare(right.left, right.right);
		}
	}

	private int depth(TreeNode root) {
		int dep = 0;
		Stack<TreeNode> s1 = new Stack<TreeNode>();
		Stack<TreeNode> s2 = new Stack<TreeNode>();
		if (root != null)
			s1.push(root);
		TreeNode node = null;
		while (!s1.isEmpty()) {
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
			dep++;
		}
		return dep;
	}

	public static void main(String[] args) {

	}

}
