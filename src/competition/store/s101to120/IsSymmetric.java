package competition.store.s101to120;

import java.util.Stack;

public class IsSymmetric {
	/**
	 * µü´ú
	 *
	 * @param root
	 * @return
	 */
	public boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
		Stack<TreeNode> l = new Stack<TreeNode>();
		Stack<TreeNode> r = new Stack<TreeNode>();
		l.push(root.left);
		r.push(root.right);
		TreeNode lNode = null;
		TreeNode rNode = null;

		while (!l.isEmpty() && !r.isEmpty()) {
			lNode = l.pop();
			rNode = r.pop();
			if ((lNode == null && rNode != null) || (lNode != null && rNode == null))
				return false;
			if (lNode == null && rNode == null)
				continue;
			if (lNode.val != rNode.val)
				return false;
			l.push(lNode.left);
			l.push(lNode.right);
			r.push(rNode.right);
			r.push(rNode.left);
		}

		return true;
	}

	public boolean isSymmetric2(TreeNode root) {
		if (root == null)
			return true;
		return compare(root.left, root.right);
	}

	private boolean compare(TreeNode left, TreeNode right) {
		if (left == null && right == null) {
			return true;
		} else if (left != null && right != null) {
			if (left.val != right.val) {
				return false;
			}else{
				return compare(left.left, right.right)&&compare(left.right, right.left);
			}
		} else {
			return false;
		}

	}

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
