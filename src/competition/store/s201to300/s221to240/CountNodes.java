package competition.store.s201to300.s221to240;

import competition.structure.TreeNode;

public class CountNodes {

	public int countNodes(TreeNode root) {
		if (root == null)
			return 0;
		int leftCount = 0;
		int rightCount = 0;

		TreeNode temp = root.left;
		while (temp != null) {
			leftCount++;
			temp = temp.left;
		}

		temp = root.right;
		while (temp != null) {
			rightCount++;
			temp = temp.right;
		}

		if (leftCount == rightCount) {
			return (int) Math.pow(2d, leftCount + 1) - 1;
		} else {
			return 1 + countNodes(root.left) + countNodes(root.right);
		}
	}

	public static void main(String[] args) {

	}

}
