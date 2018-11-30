package competition.store.s701to800.s701to720;

import competition.structure.TreeNode;

public class InsertIntoBST {

	public TreeNode insertIntoBST(TreeNode root, int val) {
		insert(root, val);
		return root;
	}

	private void insert(TreeNode root, int val) {
		if (root == null)
			return;
		if (root.val > val) {
			if (root.left != null) {
				insert(root.left, val);
			} else {
				root.left = new TreeNode(val);
			}
		} else {
			if (root.right != null) {
				insert(root.right, val);
			} else {
				root.right = new TreeNode(val);
			}
		}
	}

	public static void main(String[] args) {

	}

}
