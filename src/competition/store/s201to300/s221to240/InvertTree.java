package competition.store.s201to300.s221to240;

import competition.structure.TreeNode;

public class InvertTree {

	public TreeNode invertTree(TreeNode root) {
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;

		invertTree(root.left);
		invertTree(root.right);

		return root;
	}

	public static void main(String[] args) {

	}

}
