package competition.store.s601to700.s641to660;

import java.util.Stack;

import competition.structure.TreeNode;

public class FindTarget {

	public boolean findTarget(TreeNode root, int k) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if (root != null)
			stack.push(root);

		while (!stack.isEmpty()) {
			TreeNode popNode = stack.pop();
			TreeNode findNode = find(root, k - popNode.val);
			if (findNode != null && findNode != popNode)
				return true;
			if (popNode.right != null)
				stack.push(popNode.right);
			if (popNode.left != null)
				stack.push(popNode.left);
		}

		return false;
	}

	private TreeNode find(TreeNode root, int k) {
		while (root != null) {
			if (root.val == k)
				return root;
			if (root.val > k) {
				root = root.left;
			} else {
				root = root.right;
			}
		}

		return null;
	}

	public static void main(String[] args) {

	}

}
